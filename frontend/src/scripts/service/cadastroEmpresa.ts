export function sayHiEmp(): void {
  console.log('Hi from cadastro empresa! im working!');
}

const buttonEmpresa = document.getElementById('teste-empresa')


buttonEmpresa?.addEventListener('click', () => {
  console.log('click')
  sayHiEmp();
})
