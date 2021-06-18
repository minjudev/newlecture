// ------- OO JavaScript: JavaScript Object Oriented Programming -------
class Exam {
    constructor() {
        this.kor = 10;
        this.eng = 20;
        this.math = 30;
    }

    total() {
        return this.kor+this.eng+this.math;
    }
}

Exam.prototype.aa = function() {
    return 10;
}

let exam = new Exam();
console.log(typeof Exam); // function
console.log(Exam.prototype.total);
console.log(exam.aa());
// console.log(exam.total());

Array.prototype.몰라몰라 = function() {
    console.log("호호호");
}

let ar = [2,3,4];
ar.몰라몰라();


function print11() { // 행위를 나타내는 동사형
    console.log(this); // window 객체
}

print11();


// 데이터 객체를 만들어서 초기화하는 목적의 함수: 생성자
// function Exam() { // 데이터 구조를 나타냄, Exam: 자료형
//     // console.log(this); // Exam 객체
//     // this 생략 불가능
//     this.kor = 0; // 초기화
//     this.eng = 10;
//     this.math = 20;
// }

// Exam.prototype.aa = [1,2,3];
// Exam.prototype.total = function() {
//     return this.kor+this.eng+this.math;    
// }

// let exam1 = new Exam();
// let exam2 = new Exam();
// console.log(exam1.total === exam2.total); // True
// console.log(exam1.aa === exam2.aa); // True
// console.log(exam.total()); // 여기서 total 메소드는 this.kor~this.math를 사용하는 게 아니라
                              // 전달된 Exam 인스턴스를 사용



// ------- Function Rest/Spread/Default -------
// Rest Operator
function print(x, y, ...restValues){};
// Spread Operator
function print(x, y, z){};
let arr = [1,2,3];
print(...arr);
// Default values
function print(x, y=10) {
    console.log(arguments.length); // arguments에는 default 값이 아닌 함수로 전달한 값만 들어간다!
    console.log(`x: ${x}, y:${y}`);
}

print(10);

// let kor=0, eng=10, math=20;
// let [kor, eng, math] = [kor, eng, math]; // 왼쪽은 뽀개기, 오른쪽은 배열 객체
 
// ------- Arrow Function -------
let arr1 = [34, 2, 3, 44, 6, 23, 12, 2, 7, 5];
arr1.sort((a, b) => b - a);
console.log(arr1);



// ------- Collection -------
/*
let set = new Set();
set.add(5);
set.add(5);
set.add(5);
set.add(6);

console.log(set.size); // 2

let arr = [2, 3, 4, 2, 1, 2, 4, 3, 5, 6, 12];
let lotto = new Set(arr);
console.log(lotto.size); // 7
*/

// 전체를 나열하는 서비스
// 1. foreach: 원래 지원되던 과거의 방법
// -> for-in: 키를 뽑아주는 제어 구조
// lotto.forEach(function(v, k, s) { // s: lotto, 키와 값을 뽑아낸 원본
//     console.log(`k:${k}, v:${v}`);
// })

// for(let key in set) {
//     console.log(key);
// } // 결과 출력 안됨

// 2. iterator: es6에서부터 지원하는 새로운 방법
// -> for-of: 값을 뽑아주는 제어 구조
// for(let v of set) {
//     console.log(v);
// }

// ---> iterator, for of를 쓰는 게 바람직하다!

let ob1 = {};
let ob2 = {};

let s1 = "hello";
let s2 = "hello";

let set = new Set();
set.add(ob1);
set.add(ob2);

ob1 = null; // set에서 담은 것과 해당하는 줄의 코드는 상관없다는 말?

console.log(set.size);

// let exam = new Map();
// exam.set("kor", 10);
// exam.set("eng", 20);
// exam.set("math", 30);

// // iterator는 for in문 사용 불가
// // for of문으로 iterator 반복하기
// for(let k of exam.keys()) { // key 뽑아내기
//     console.log(exam.get(k)); // key를 가지고 값 꺼내기
// }

// for(let v of exam.values()) {
//     console.log(v); 
// }

// for(let [k, v] of exam.entries()) {
//     console.log(`key: ${k}, values: ${v}`); 
// } 

// exam.forEach((v, k , obj)=> {
//     console.log(`key: ${k}, values: ${v}`); 
// });

// let set1 = new Set([2, 10, 2, 1, 2, 4, 3, 4]);
// console.log("set1" + set1);
// let array = [...set1];
// console.log(array);