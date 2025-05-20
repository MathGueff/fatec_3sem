const urlBase = 'http://localhost:3000/'+ 'api'

document.getElementById('formLogin').addEventListener('submit', function(event){
        event.preventDefault();
        const msgModal = new bootstrap.Modal(document.getElementById('modalMensagem'))

        const nome = document.getElementById('nome').value
        const login = document.getElementById('login').value
        const senha = document.getElementById('senha').value

        const dadosLogin = {
            nome : nome,
            email : login,
            senha : senha
        }

        fetch(`${urlBase}/usuarios`, {
            method: 'POST',
            headers: {'Content-type' : "application/json"},
            body: JSON.stringify(dadosLogin)
        })
        .then(response => response.json())
        .then(data => {
            if(data){
                window.location.href = 'index.html'
                document.getElementById('mensagem').innerHTML = `Usuário criado com sucesso`
            } else if(data.errors) {
                const errorMessages = data.errors.map(error => error.msg).join('<br>')
                document.getElementById('mensagem').innerHTML = `<span class='text-danger'>${errorMessages}</span>`
            }
            msgModal.show();
        })
})