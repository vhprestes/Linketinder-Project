export function sayHi(): void {
  console.log('Hi from cadastro candidato! im working!');
}

const buttonCandidato = document.getElementById('teste-candidato')


buttonCandidato?.addEventListener('click', () => {
  console.log('clicked')
  sayHi();
})
