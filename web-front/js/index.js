var exams = [
    { kor: 30, eng: 40, math: 50 },
    { kor: 31, eng: 41, math: 51 },
    { kor: 32, eng: 42, math: 52 },
];

console.log(exams[2].math); // 52

var exam = {} // new Object();
exam.kor = 30;
exam.eng = 40;
exam.math = 50;
exam["math"] = 70;
exam["w-1"] = 100;

console.log(exam["w-1"] + exam.math);

var nums = new Array(1,2,3,4,5);
console.log(nums);
nums.splice(2,1); // 2에서부터 1개를 삭제
console.log(nums);
nums.splice(2,0,4,3); // 2번째 위치부터 0개를 삭제하고 2번째 위치에 3, 4라는 숫자를 추가
                      // 2번째 위치에 3, 4가 추가
console.log(nums);

var subNums = nums.slice(1,3); // 1부터 2까지 잘라냄
console.log(subNums);
console.log(nums.length);
console.log(nums.sort());
console.log(nums.indexOf(3));

var nums1 = new Array(5, 10);
console.log(nums1);

var nums2 = new Array(5, 10, "hello", new Array(1,2,3));
console.log(nums2);
console.log(typeof nums2[3][2]);

// 데이터를 저장하는 구조: 자료구조
// Stack(LIFO) 구조(제일 나중에 넣었던 요소가 가장 먼저 출력됨)
// --> [1 5 2] -->
var q = new Array();
q.push(2); // 데이터를 뒤에 넣어줌
q.push(5);
q.push(1);
q.unshift(10); // 데이터를 앞에 넣어줌
console.log(q);
console.log(q.pop());
console.log(q.pop());
console.log(q.pop());

// Queue(FIFO) 구조: 버퍼(제일 먼저 넣었던 요소가 가장 먼저 출력됨)
var q1 = new Array();
q.push(2);
q.push(5);
q.push(1);
console.log(q.shift());
console.log(q.shift());
console.log(q.shift());
