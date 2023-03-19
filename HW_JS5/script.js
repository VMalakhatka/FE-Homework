
// Создать кнопку и красный квадрат с размерами 200х200px. 
// При клике на кнопку менять у квадрата цвет заднего фона 
// на зеленый и уменьшать его до размеров 100х100px.
console.log('Hello')
const item2 = document.querySelector('.item-2')
const task1 = document.querySelector('.task1')
task1.addEventListener('click', function() {
    //item2.classList.remove('red')
    item2.classList.add('green')
})
// Создать кнопку и розовый квадрат с размерами 200х200px. 
//При клике на кнопку менять цвет на синий и выводить в консоль обновленный цвет квадрата.
const item1 = document.querySelector('.item-1')
const task2 = document.querySelector('.task2')
task2.addEventListener('click', function() {
    item1.classList.add('blue')
    console.log(`Цвет фона  ${item1.bacgroundСolor}`)
})
// Создать кнопку и квадрат с размерами 150х150px. 
//При клике на кнопку увеличивать высоту и ширину квадрата на 20px.
const item3 = document.querySelector('.item-3')
const task3 = document.querySelector('.task3')
task3.addEventListener('click', function(event) {
    item3.style.height = item3.clientHeight + 20 + 'px';
    item3.style.width = item3.clientWidth + 20 + 'px';
   
})


// Создать кнопку и div с классом root. При клике на кнопку 
// в div создается параграф синего цвета. Текст параграфа произвольный.

const root = document.querySelector('.root')
const task4 = document.querySelector('.task4')
task4.addEventListener('click', function() {
    root.innerHTML='<p class="blue_text">Lorem ipsum dolor sit amet c</p>'
})

//Создать кнопку и div с классом root. При клике на кнопку в div 
//создаются по очереди параграфы синего и зеленого цветов. Первый цвет синий.

const greentext = document.querySelector('.bl_gr')
const task5 = document.querySelector('.task5')
task5.addEventListener('click', function() {
    greentext.classList.toggle('green_text')
})