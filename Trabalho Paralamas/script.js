// Script para adicionar interatividade

// Seleciona todos os botões de iniciar jogos
const startButtons = document.querySelectorAll('.start-button');

// Adiciona um ouvinte de evento a cada botão de iniciar jogo
startButtons.forEach(button => {
  button.addEventListener('click', () => {
    // Simula o início do jogo
    alert('Jogo iniciado!');
    
    // Atualiza a pontuação do jogo
    const scoreElement = button.parentElement.querySelector('.score');
    const currentScore = parseInt(scoreElement.textContent.split(' ')[1]);
    scoreElement.textContent = `Pontuação: ${currentScore + 10}`;
  });
});
