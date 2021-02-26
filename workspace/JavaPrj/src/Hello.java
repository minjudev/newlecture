class Hello {
    public static void main(String[] args) {
        int kor, eng; 
        int math; 
        int total;
        float avg;

        kor = 90;
        eng = 100;
        math = 97;

        total = kor + eng + math;
        avg = total / 3.0f;

        //System.out.printf("total is %d\n", total);
        
        System.out.println("┌───────────────────────────┐");
        System.out.println("│          성적 출력          │");
        System.out.println("└───────────────────────────┘");
        
        System.out.printf("국어 : %d\n", kor);
        System.out.printf("영어 : %d\n", eng);
        System.out.printf("수학 : %d\n", math);
        
        System.out.printf("총점 : %d\n", total);
        System.out.printf("평균 : %3.2f\n", avg);
        
        System.out.write(51);
        
  

       
        
        System.out.print("A"); 



      
        //System.out.printf("%1$d, %2$d, %1$d, %2$d, %3$d\n", 1, 2, 5);

        System.out.println("─────────────────────────────");
    }
}