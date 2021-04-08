package ex09.인터페이스.exam;

// 1. 인터페이스 정의하기
// 인터페이스를 다른 곳에서 사용해야 하니까 public으로 구현
// 인터페이스를 구현하는 것은 어느 곳에서나 해도 됨(하지만, 구현되는 장소는 중요)
public interface Banner {

	// 인터페이스에서는 약속을 정의&나열할 뿐 구현하지는 않음(구현체가 아니므로 public, private 작성X)
	void printStart();
	void printEnd();
	
}
