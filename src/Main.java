import java.util.Scanner;

public class Main {
	private Company com=new Company();
	Main(){
		com.addEmployee(new Employee("张三",001));
		com.addEmployee(new Employee("李四",002));
		com.addEmployee(new Employee("王五",003));
		com.addEmployee(new Employee("赵六",004));
		System.out.println("员工信息加载成功！");
	}
	public void menu() {
		System.out.println("----员工打卡系统----\r\n" + 
				           "输入 0--------退出\r\n" + 
			               "输入 1--------签到\r\n" + 
			               "输入 2--------签退\r\n" + 
			               "输入 3--------查看签到信息\r\n" + 
							"请输入想执行的操作："	);
	}
	public void registerStart() {
		//家里ssdadasda
		System.out.println("请输入签到员工ID");
		Scanner scan=new Scanner(System.in);
		Employee temp=com.searchEmployee(scan.nextInt());
		if(temp==null) {
			System.out.println("无此ID员工");
		}else {
			com.registerStart(temp.getID());
		}	
	}
	public void registerEnd() {
		System.out.println("请输入签退员工ID");
		Scanner scan=new Scanner(System.in);
		Employee temp=com.searchEmployee(scan.nextInt());
		if(temp==null) {
			System.out.println("无此ID员工");
		}else {
			com.registerEnd(temp.getID());
		}	
	}
	
	public void run() {
		while(true) {
			menu();
			Scanner scan=new Scanner(System.in);
			int choose=scan.nextInt();
			if(choose==0) {
				System.out.println("已退出程序！");
				break;
			}else if(choose==1) {
				registerStart();
			}else if(choose==2) {
				registerEnd();
			}else if(choose==3) {
				com.showEmployee();
			}else {
				System.out.println("输入错误！");
			}
		}
	}
	
	public static void main(String[] args) {
		Main a=new Main();
		a.run();

	}
}
