// Initialize Monaco Editor
require.config({ paths: { vs: 'https://cdnjs.cloudflare.com/ajax/libs/monaco-editor/0.45.0/min/vs' } });

require(['vs/editor/editor.main'], function () {
  window.editor = monaco.editor.create(document.getElementById('editor'), {
		value:'print("Welcome to Quark")',
    language: 'java',
    theme: 'vs-dark',
    automaticLayout: true
  });
});

// Tab switching
document.querySelectorAll('.tab-button').forEach(button => {
  button.addEventListener('click', () => {
    document.querySelectorAll('.tab-button').forEach(btn => btn.classList.remove('active'));
    button.classList.add('active');

    const target = button.getAttribute('data-target');
    document.querySelectorAll('.tab-content').forEach(content => {
      content.classList.remove('visible');
    });
    document.getElementById(target).classList.add('visible');
  });
});

document.getElementById('runBtn').addEventListener('click', async () => {
  const code = editor.getValue();
	try{
		const response = await fetch("/code", {
			method: "POST",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify({ code })
		});
		const data = await response.json()
		console.log(data)
		document.getElementById('output').textContent = data.result
	}catch(err){
		console.log(err)
		document.getElementById('output').textContent = "Error :" + err
	}

});

