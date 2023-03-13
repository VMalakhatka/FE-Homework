const numbers = document.querySelector('.numbers')
for(let i=100; i>=50; i-=10 ){
   numbers.innerHTML +=` <p> ${i} </p>`
}

const strings_container = document.querySelector('.strings_container')
const str_arr = ['sddfswefd' , 'ewjhfekwrmjfn' , 'fjeirhfjerhbjdfgjhb' , 'erhbfejfhb']

for(i=0; i<str_arr.length; i++ ){
    strings_container.innerHTML +=` <p> ${str_arr[i]} </p>`
 }

 const users_arr = [
  {
    first_name: 'Pety',
    last_name: 'Ivanov',
    age: 18
  },
  {
    first_name: 'Vany',
    last_name: 'Petrov',
    age: 19
  }
 ]
 const users_container = document.querySelector('.users_container')

 for(i=0; i<users_arr.length; i++ ){
    users_container.innerHTML +=` 
    <div> 
        <p>Имя: ${users_arr[i].first_name}</p> 
        <p>Фамилия: ${users_arr[i].last_name}</p>
        <p>Возраст: ${users_arr[i].age}</p>
    </div>
    `
 }

