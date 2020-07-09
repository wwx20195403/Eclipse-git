import java.util.ArrayList;

public class Company {
	 private ArrayList<Employee> list=new ArrayList ();
	 private ArrayList<DakaInfo> message=new ArrayList<>();
	public Company() {
		
	}
	public void addEmployee(Employee e) {
		list.add(e);
		message.add(new DakaInfo(e.getID()));
		System.out.println(e.toString()+"添加成功");
	}
	public void removeEmployee(int ID) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getID()==ID) {
				list.remove(i);
				System.out.println("删除成功！");
			}
		}
	}
	public Employee searchEmployee(int ID) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getID()==ID) {
				return list.get(i);
			}
		}
		return null;
	}
	public void showEmployee() {
		for(int i=0;i<list.size();i++) {
						System.out.println("----------------------------------------------------------------");
						System.out.println("姓名："+list.get(i).getName());
						System.out.println("ID："+list.get(i).getID());
						System.out.println("签到时间：\n"+message.get(i).getStart());
						System.out.println("签退时间：\n"+message.get(i).getEnd());
						System.out.println("----------------------------------------------------------------");
		}
	}
	public void  registerStart(int ID) {
		for(DakaInfo a :message) {
			if(a.getID()==ID) {
				if(a.setStart()) {
					System.out.println("卡号："+ID+"  打卡成功");
				}else {
					System.out.println("今天已经打过卡了");
				}
			}
		}
	}
	public void  registerEnd(int ID) {
		for(DakaInfo a :message) {
			if(a.getID()==ID) {
				int aa=a.setEnd();
				if(aa==0) {	
					System.out.println("卡号："+ID+"  今天还没有签到，无法签退");
				}else if(aa==-1) {
					System.out.println("你今天已经签退过了！");
				}else if(aa==1) {
					System.out.println("卡号："+ID+"   签退成功");
				}
	
			}
		}
	}
	
}
