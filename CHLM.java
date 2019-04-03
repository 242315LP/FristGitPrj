package System;

import java.util.Scanner;

/*
 * 吃货联盟订餐系统
 */
public class CHLM {
	public static void main(String[] args) {
		String[] names = new String[4];//订餐人
		String[] dishMegs = new String[4];//所定餐品信息
		int[] times = new int[4];//送餐时间
		String[] addresses = new String[4];//送餐地址
		int[] states = new int[4];//订单状态，0已预订，1已完成
		double[] sumPrices = new double[4];//总金额
		
		//初始化两条订单信息
		names[0] = "曾仁旭";
		dishMegs[0] = "红烧带鱼 1份";
		times[0] = 12;
		addresses[0] = "13栋329";
		states[0] = 1;
		sumPrices[0] = 18.0;
		
		names[1] = "罗佳福";
		dishMegs[1] = "鱼香肉丝 2份";
		times[1] = 12;
		addresses[1] = "13栋329";
		states[1] = 0;
		sumPrices[1] = 38.0;
		
		//数据主体，一组餐品信息
		String[] dishNames = {"红带烧鱼","鱼香肉丝","时令蔬菜"};//餐品名称
		double[] prices = {38.0,18.0,10.0};//餐品价格
		int[] praiseNums = new int[3];//点赞数
		Scanner input = new Scanner(System.in);
		
		int num = -1;//记录用户输入的数字
		do {
			/*
			 * 循环操作
			 * 显示主菜单
			 */
			System.out.println("*******************");
			System.out.println("1.我要定餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("*******************");
			/*
			 * 提示用户输入功能编号，并执行相应功能
			 */
			System.out.print("请选择：");
			int choose = input.nextInt();
			boolean isAdd = false;  //true:记录找到一个为空的位置，可以插入，false：没有找到
			
			switch (choose) {
			case 1:
				//1.我要订餐
				System.out.println("****我要订餐****");
				//1.查找要插入的位置
				for (int i = 0; i < names.length; i++) {
					//如果找到为空的位置，记录下来
					if (names[i]==null) {
						isAdd = true; //记录找到一个为空的位置
						//执行插入操作
						//显示所有可供选择的餐品信息
						System.out.println("序号\t餐品名\t单价\t点赞数");
						for (int j = 0; j < dishNames.length; j++) {
							String price = prices[j]+"元";
							String praise = praiseNums[j]+"赞";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);									
						}
						
						//输入所选餐品编号及份数
						System.out.print("请选择所定餐品序号：");
						int chooseDish = input.nextInt();
						System.out.print("请输入所定份数:");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish-1]+" "+number+"份";
						
						//输入订餐人姓名
						System.out.print("请输入订餐人姓名:");
						String name = input.next();
						
						//输入送餐时间
						System.out.print("请输入送餐时间（10~20整点送餐）:");
						int time = input.nextInt();
						//如果输入错误，重新输入
						while (time<10 || time>20) {
							System.out.println("对不起，你的输入有误，请输入10~20之间的整数：");
							time = input.nextInt();
						}
						
						//输入送餐地址
						System.out.print("请输入送餐地址：");
						String address = input.next();
						
						//计算餐费
						double sumPrice = prices[chooseDish-1] * number;
						//送餐费，当餐费 达到50元时，免6元送餐费
						double deliCharge = sumPrice>=50?0.0:6.0;
						
						//显示订单信息
						System.out.println("订餐成功！");
						System.out.println("您订的是："+dishMeg);
						System.out.println("订餐人："+name);
						System.out.println("送餐时间："+time+"点");
						System.out.println("送餐地址："+address);
						System.out.println("餐费："+sumPrice+",送餐费"+deliCharge+"元");
						System.out.println("总金额："+(sumPrice+deliCharge)+"元");
						
						//保存数据
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice;						
						
						break;
					}
				}
				
				//如果没有找到为空的位置，则提示信息
				if (!isAdd) {
					System.out.println("对不起，你的餐袋已满！");
				}
				
				break;
			case 2:
				//2.查看餐袋
				System.out.println("****查看餐袋****");
				System.out.println("序号\t订餐人\t所订餐品信息\t送餐时间\t送餐地址\t\t总金额\t状态");
				//遍历数组
				for (int i = 0; i < names.length; i++) {
					if (names[i]!=null) {					
						String time = times[i]+"点";
						String sumPrice = sumPrices[i]+"元";
						String state = states[i]==0?"已预订":"已完成";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t\t"+sumPrice+"\t"+state);
						
					}
				}
				break;
            case 3:
            	//3.签收订单
            	System.out.println("****签收订单****");
            	//要求用户输入一个签收的订单号
            	System.out.print("请输入要签收的订单号：");
            	int signOrderID = input.nextInt();
            	boolean isFind = false; //记录是否找到了这条订单，true：找到了，false：没找到
            	//查找这条订单号（循环遍历）
            	for (int i = 0; i < names .length; i++) {
					/*1、找到，状态是已完成，提示不能再次签收
					 * 2、找到，状态是已预订，可以签收
					 */
            		if (names[i]!=null && states[i]==1 && signOrderID==i+1) {
						System.out.println("对不去，您选择的订单已签收，不能再次签收！");
						isFind = true;
						break;
					}else if (names[i]!=null && states[i]==0 && signOrderID==i+1) {
						states[i]=1; //状态值改为已完成状态
						System.out.println("订单签收成功！");
						isFind = true;
						break;
					}            		
				}
            	//条件判断：如果没有找到这条订单，提示没有找到
            	if (!isFind) {
					System.out.println("对不去，这条订单不存在！");
				}
				break;
            case 4:
            	//4.删除订单
            	System.out.println("****删除订单****");
            	//输入要删除的订单序号
            	System.out.print("请输入您要删除的订单号：");
            	int delID = input.nextInt();
            	int delIndex = -1; //记录删除订单的下标
            	boolean isDelFind = false; //记录是否找到要删除的订单
            	//循环查找这条订单
            	for (int i = 0; i < names.length; i++) {
					/*找到此订单，已签收：执行删除操作（腺肌瘤要删除的订单序号）
					 * 找到此订单，未签收：提示信息，不可删除
					 */
            		if (names[i]!=null && states[i]==1 && delID==i+1) {
						delIndex = i;
						isDelFind = true;
						break;
					}else if (names[i]!=null && states[i]==0 && delID==i+1) {
						System.out.println("您选择的订单未签收，不能删除！");
						isDelFind = true;
						break;
					}
				}
            	//未找到此订单，提示信息
            	if (!isDelFind) {
					System.out.println("对不起，此订单不存在");
				}
            	
            	//执行删除操作
            	if (delIndex!=-1) {
					//删除操作（循环移位），从要删除的元素后面一个开始到数组最后一个元素依次向前移动一位
            		for (int i = delIndex+1; i <= names.length-1; i++) {
						names[i-1]=names[i];
						dishMegs[i-1]=dishMegs[i];
						times[i-1]=times[i];
						addresses[i-1]=addresses[i];
						states[i-1]=states[i];
					}
            		//最后一位清空
            		names[names.length-1] = null;
            		dishMegs[dishMegs.length-1] = null;
            		times[times.length-1] = 0;
            		addresses[addresses.length-1] = null;
            		states[states.length-1] = 0;
            		
            		System.out.println("订单删除成功！");
            		
				}
				break;
            case 5:
            	//5.我要点赞
            	System.out.println("****我要点赞****");
            	//显示可供点赞的餐品列表
            	System.out.println("序号\t餐品名\t单价\t点赞数");
				for (int j = 0; j < dishNames.length; j++) {
					String price = prices[j]+"元";
					String praise = praiseNums[j]+"赞";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);									
				}
            	//输入要点赞的餐品序号
				System.out.print("请输入要点赞的餐品序号：");
				int dishID = input.nextInt();
            	//该序号的餐品点赞数加一
				praiseNums[dishID-1]++;
            	//显示
				System.out.println("点赞成功！");
				System.out.println(dishNames[dishID-1]+" "+praiseNums[dishID-1]+"赞");
				break;
            case 6:
            	//6.退出系统
            	break;
			default:
				break;
			}
			//当用户输入的功能编号为1~5之外的数字时，退出系统
			if (choose>5 || choose<1) {
				break;
			}else{
			//提示输入0返回
			System.out.print("输入0返回：");
			num = input.nextInt();
			}
		} while (num==0);
		System.out.println("谢谢使用，欢迎下次光临！");
	}
}
