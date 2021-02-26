class Hello {
    public static void main(String[] args) {
        int kor, eng; 
        int math; 
        int total;
        double avg;

        kor = 90;
        eng = 100;
        math = 95;

        total = kor + eng + math;
        avg = total / 3;

        //System.out.printf("total is %d\n", total);
        
        System.out.print("┌───────────────────────────┐\n");
        System.out.print("│          성적 출력          │\n");
        System.out.print("└───────────────────────────┘\n");
        
        System.out.print("국어1 : 0\n");
        System.out.print("국어2 : 0\n");
        System.out.print("국어3 : 0\n");
        System.out.print("총점 : 0\n");
        System.out.print("평균 : 0\n");

        System.out.print("─────────────────────────────\n");
    }
}

