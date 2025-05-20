const urlBase = 'http://localhost:3000/api'

document.getElementById('formLogin').addEventListener('submit', function(event){
        event.preventDefault();
        const msgModal = new bootstrap.Modal(document.getElementById('modalMensagem'))

        const login = document.getElementById('login').value
        const senha = document.getElementById('senha').value

        const dadosLogin = {
            email : login,
            senha : senha
        }

        fetch(`${urlBase}/usuarios/login`, {
            method: 'POST',
            headers: {'Content-type' : "application/json"},
            body: JSON.stringify(dadosLogin)
        })
        .then(response => response.json())
        .then(data => {
            console.log(data.errors)
            if(data.access_token){
                localStorage.setItem('token', data.access_token)
                window.location.href = 'municipios.html'
                document.getElementById('mensagem').innerHTML = `Tudo certo`
            } else if(data.errors) {
                const errorMessages = data.errors.map(error => error.msg).join('<br>')
                document.getElementById('mensagem').innerHTML = `<span class='text-danger'>${errorMessages}</span>`
            }
            msgModal.show();
        })
})