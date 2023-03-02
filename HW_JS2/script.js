for(let i=2; i<=10;){
    console.log(i)
    i=i+2
}
for(i=55;i>=20;i--){
    console.log(i)
}
const numbers = [3, 5, 11, 2, 8, 1, 6];
for(i=0;i<numbers.length;i++){
    console.log(numbers[i])
}
const numbers_squared = []
for(i=0;i<numbers.length;i++){
    numbers_squared.push(numbers[i]**2)
}
console.log(numbers_squared)
let last_elem
last_elem = numbers_squared[numbers_squared.length-1]
console.log(last_elem)
const user = {
    first_name: 'Ivan', 
    last_name: 'Ivanov', 
    age: 20, 
    salary: 500
    }
console.log(`User’s name is ${user.first_name} ${user.last_name}. He is ${user.age} years old`)    