// Função para buscar o cliente pelo CPF e exibir suas informações
function buscarCliente() {
    var cpfBusca = document.getElementById('buscarCPF').value;
    var clienteEncontrado = tabelaHash[cpfBusca];

    var resultadoDiv = document.getElementById('resultadoBusca');

    if (clienteEncontrado) {
        resultadoDiv.innerHTML = ''; // Limpa o conteúdo anterior

        // Cria elementos para exibir as informações do cliente
        var nomeParagrafo = document.createElement('p');
        nomeParagrafo.textContent = 'Nome: ' + clienteEncontrado.nome;

        var emailParagrafo = document.createElement('p');
        emailParagrafo.textContent = 'Email: ' + clienteEncontrado.email;

        var telefoneParagrafo = document.createElement('p');
        telefoneParagrafo.textContent = 'Telefone: ' + clienteEncontrado.telefone;

        // Adiciona os parágrafos à div de resultado
        resultadoDiv.appendChild(nomeParagrafo);
        resultadoDiv.appendChild(emailParagrafo);
        resultadoDiv.appendChild(telefoneParagrafo);
    } else {
        resultadoDiv.innerHTML = 'Cliente não encontrado!';
    }
}
