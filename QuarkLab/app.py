from flask import Flask , request , jsonify , render_template
import subprocess
import re

app = Flask(__name__)

@app.route('/')
def homepage():
    return render_template("index.html")

#strip the ascii
def strip_ansi(text):
    return re.sub(r'\x1B\[[0-?]*[ -/]*[@-~]', '', text)

@app.route("/code" , methods=['Post'])
def hello_world():
    data = request.get_json()
    if not data or 'code' not in data:
        return jsonify({"eror" : "Missing 'code'"})
    
    with open("main.quark" , 'w') as f:
        f.write(data['code'])

    print("wrote" , data['code']) 

    compile_result = subprocess.run(
            ['java' , '-jar' , 'Quark.jar' , 'main.quark'],
            capture_output=True,
            text=True
        )

    if compile_result.returncode == 0:
        print("compilation success")
        run_result = subprocess.run(
            ['java' ,'main'],
            capture_output=True,
            text=True
        )

        result = strip_ansi(run_result.stdout)
        return jsonify({'result':result})        

    else:
        print("compilation failed")
        return jsonify({'result': strip_ansi(compile_result.stdout)} )

if __name__ == "__main__":
    app.run(debug=True)
