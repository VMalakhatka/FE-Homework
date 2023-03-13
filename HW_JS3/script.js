function minTwo(a,b){
    return Math.min(a,b)
}

console.log(minTwo(1,4))
console.log(minTwo(7,4))

function parytyTwo(a,b){
    let min=Math.min(a,b)
    let max=Math.max(a,b)
    for(let i=Math.ceil(min/2)*2 ; i<=max; i+=2){
        console.log(i)
    }
}

parytyTwo(3,7)
parytyTwo(6,2)

function power(a,b){
    if(b===undefined){
        return Math.pow(a,2)
    }else{
        return Math.pow(a,b)
    }
}

console.log(power(2,4))
console.log(power(3))

function count(n){
    let sum=0
    for(let i=1; i<=n; i++){
        sum+=i
    }
    return sum
}

console.log(count(5))
console.log(count(6))

function sumPnP(a,b){
    let min=Math.min(a,b)
    let max=Math.max(a,b)
    let sumP = 0
    let sumNP =0 
    for(let i=min ; i<=max; i+=1){
        if (i%2==0) {
            sumP+=i
        } else {
            sumNP+=i
        }
    }
    console.log(`Сумма четных чисел ${sumP}`)
    console.log(`Сумма нечетных чисел ${sumNP}`)
}

sumPnP(5,8)
sumPnP(10,2)

const arr = [ 'one', 'two', 'three' ] 

function findMax(a){
    let str = a[0]
    if (a.length==0) {
        return null
    } else { 
        for(let i=1 ; i< a.length ; i++){
            if(str.length<a[i].length){
                str=a[i]
            }
        }
        return str
    }
}

console.log(findMax(arr))
console.log(findMax([]))