// onclick 이벤트 함수 작성
function printSum() {
    var x, y;
    x = prompt('x 값을 입력하세요', 0);
    y = prompt('y 값을 입력하세요', 0);
    
    x = parseInt(x);
    y = parseInt(y);
    alert(x+y);
}

var html = "<span>안녕하세요!</span>";
asideTitle.innerHTML = html;
// window.document.write(html);

// --- Browser Object -----------------------------------------------------------------------------------
var result = window.confirm("정말 삭제하시겠습니까?");
console.log(result);

// var a = 3;
// var b = 0;
// window.alert(a+b);

// var x, y;
// x = prompt("x 값을 입력하세요", 0);
// y = prompt("y 값을 입력하세요", 0);

// x = parseInt(x);
// y = parseInt(y);
// alert(x+y);

// --- 함수 -----------------------------------------------------------------------------------

function f() {
    a = 100;
}

f();
console.log(a);

function f1() {
    // x 앞에 var를 쓰지 않으면 오류가 나지 않음
    // window.x = 1이라고 인식되기 때문에
    // 전역변수에 x를 추가한 것임
    x = 1;
    return x;
}

f1();
// 여기서도 window.x가 출력됨
console.log(x);

var x = 1;
console.log(window.x);

// var add = new Function("x, y", "return x+y;");

// 오류 발생 O
// add라는 변수는 준비되어있지만 변수가 아직 function이 아님
// undefined인 add를 함수처럼 쓰려고 하니까 오류 발생
// var result = add(3, 4);

// var add = function(x, y) {
//     return x + y;
// };

// console.log(result);

// 오류 발생 X
// add라는 변수가 선언됨과 동시에 함수가 대입됨
var result = add(3, 4);

function add(x, y) {
    return x + y;
}

console.log(result);

// -----------------------------------------------------------------------------------

var json = `{"kor": 90}`;
var data = JSON.parse(json);
console.log(data.kor); // 90

a = 1;
console.log(a);

// 컬렉션의 개념이 없는 js에서 두 가지의 컬렉션을 가짐
// 배열, 객체

var ar = [2, 3, 4];
var obj = { kor: 10, eng: 20, math: 30 };

for (var i = 0; i < ar.length; i++) console.log(ar[i]);

// for-in / for-of: 배열의 인덱스를 사용하지 않고 for문 사용
for (var i in ar) //
    console.log(ar[i]);

for (var key /*kor*/ in obj) console.log(obj[key]);

// -----------------------------------------------------------------------------------

var x = "hello";
var y = new String("hello");

console.log(x == y); // 값을 비교 -> 자바(.equals())
console.log(x === y); // 참조를 비교(객체가 같은지 비교) -> 자바(==)

// -----------------------------------------------------------------------------------

var x;
eval("x = 3;");

// eval: 문자열을 코드처럼 실행할 수 있게 객체화해줌
// eval: 실행되는 코드가 하나의 완전한 문장이어야만 됨(ex. "data = [2,3,4,5];")
console.log(x); // 3

// JSON 문자열을 자바스크립트 객체로 변경하기
// eval을 쓸 수도 있고, JSON.parse도 쓸 수 있다.

// 1. eval
var json = "[2,3,4,5]"; // "[2,3,4,5]" 이 문장이 완전해야하는데, 이를 가능하게 해주는 트릭은 소괄호()를 붙이는 것
// var data = eval(("[2,3,4,5]"));
// var data = eval("("+json+")");
// console.log(data[2]);

// 2. JSON.parse
// JSON.parse 쓸 때는 키를 ""로 감싸줘야함
var a = { kor: 20 };

var json = '{"kor": 20}';
var data = JSON.parse(json);
console.log(data.kor);

// -----------------------------------------------------------------------------------

var exams = [
    { kor: 30, eng: 40, math: 50 },
    { kor: 31, eng: 41, math: 51 },
    { kor: 32, eng: 42, math: 52 },
];

console.log(exams[2].math); // 52

// var exam = {} // new Object();
// exam.kor = 30;
// exam.eng = 40;
// exam.math = 50;
// exam["math"] = 70;
// exam["w-1"] = 100;

// console.log(exam["w-1"] + exam.math);

// var nums = new Array(1,2,3,4,5);
// console.log(nums);
// nums.splice(2,1); // 2에서부터 1개를 삭제
// console.log(nums);
// nums.splice(2,0,4,3); // 2번째 위치부터 0개를 삭제하고 2번째 위치에 3, 4라는 숫자를 추가
//                       // 2번째 위치에 3, 4가 추가
// console.log(nums);

// var subNums = nums.slice(1,3); // 1부터 2까지 잘라냄
// console.log(subNums);
// console.log(nums.length);
// console.log(nums.sort());
// console.log(nums.indexOf(3));

// var nums1 = new Array(5, 10);
// console.log(nums1);

// var nums2 = new Array(5, 10, "hello", new Array(1,2,3));
// console.log(nums2);
// console.log(typeof nums2[3][2]);

// // 데이터를 저장하는 구조: 자료구조
// // Stack(LIFO) 구조(제일 나중에 넣었던 요소가 가장 먼저 출력됨)
// // --> [1 5 2] -->
// var q = new Array();
// q.push(2); // 데이터를 뒤에 넣어줌
// q.push(5);
// q.push(1);
// q.unshift(10); // 데이터를 앞에 넣어줌
// console.log(q);
// console.log(q.pop());
// console.log(q.pop());
// console.log(q.pop());

// // Queue(FIFO) 구조: 버퍼(제일 먼저 넣었던 요소가 가장 먼저 출력됨)
// var q1 = new Array();
// q.push(2);
// q.push(5);
// q.push(1);
// console.log(q.shift());
// console.log(q.shift());
// console.log(q.shift());
