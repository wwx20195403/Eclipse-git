import java.text.SimpleDateFormat;
import java.util.Date;

public class DakaInfo {
	private int ID;
	private Date start=null;
	private Date end=null;
	private String startHistory="";
	private String endHistory="";
	private SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public DakaInfo(int ID) {
		this.ID=ID;
	}
	//kaiakaiaisasd
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getStart() {
		if(start==null)return "无";
		return startHistory+ss.format(start);
	}
	public boolean setStart() {
		Date a=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		if(start==null) {
			start=a;
			return true;//true表示可以签到
		}else {
			String a1=s.format(start);
			if(a1.equals(s.format(a)))return false;//表示签到失败
			else {
				startHistory+=ss.format(start)+"\n";
				start=a;
				return true;
			}
		}
		
	}
	public String getEnd() {
		if(end==null)return "无";
		return endHistory+ss.format(end);
	}
	
	public int setEnd() {
		Date a=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		if(start==null) {
			return 0;  //0表示未签到，所以不能签退
		}else if(!(s.format(start).equals(s.format(a)))) {
			//如果start中的时间是昨天的时间，那么今天是不能签退的，就是今天未签到的状态,不能签退
			return 0;
			
		}else if(end==null) {
			end=a;
			return 1;//1表示签退成功
		}else {
			String a1=s.format(end);
			if(a1.equals(s.format(a)))return -1;//-1表示已经签退过了
			else {
				endHistory+=ss.format(end)+"\n";
				end=a;
				return 1;//1表示签退成功
			}
		}
	}


}
