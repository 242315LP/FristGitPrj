package System;

import java.util.Scanner;

/*
 * �Ի����˶���ϵͳ
 */
public class CHLM {
	public static void main(String[] args) {
		String[] names = new String[4];//������
		String[] dishMegs = new String[4];//������Ʒ��Ϣ
		int[] times = new int[4];//�Ͳ�ʱ��
		String[] addresses = new String[4];//�Ͳ͵�ַ
		int[] states = new int[4];//����״̬��0��Ԥ����1�����
		double[] sumPrices = new double[4];//�ܽ��
		
		//��ʼ������������Ϣ
		names[0] = "������";
		dishMegs[0] = "���մ��� 1��";
		times[0] = 12;
		addresses[0] = "13��329";
		states[0] = 1;
		sumPrices[0] = 18.0;
		
		names[1] = "�޼Ѹ�";
		dishMegs[1] = "������˿ 2��";
		times[1] = 12;
		addresses[1] = "13��329";
		states[1] = 0;
		sumPrices[1] = 38.0;
		
		//�������壬һ���Ʒ��Ϣ
		String[] dishNames = {"�������","������˿","ʱ���߲�"};//��Ʒ����
		double[] prices = {38.0,18.0,10.0};//��Ʒ�۸�
		int[] praiseNums = new int[3];//������
		Scanner input = new Scanner(System.in);
		
		int num = -1;//��¼�û����������
		do {
			/*
			 * ѭ������
			 * ��ʾ���˵�
			 */
			System.out.println("*******************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("*******************");
			/*
			 * ��ʾ�û����빦�ܱ�ţ���ִ����Ӧ����
			 */
			System.out.print("��ѡ��");
			int choose = input.nextInt();
			boolean isAdd = false;  //true:��¼�ҵ�һ��Ϊ�յ�λ�ã����Բ��룬false��û���ҵ�
			
			switch (choose) {
			case 1:
				//1.��Ҫ����
				System.out.println("****��Ҫ����****");
				//1.����Ҫ�����λ��
				for (int i = 0; i < names.length; i++) {
					//����ҵ�Ϊ�յ�λ�ã���¼����
					if (names[i]==null) {
						isAdd = true; //��¼�ҵ�һ��Ϊ�յ�λ��
						//ִ�в������
						//��ʾ���пɹ�ѡ��Ĳ�Ʒ��Ϣ
						System.out.println("���\t��Ʒ��\t����\t������");
						for (int j = 0; j < dishNames.length; j++) {
							String price = prices[j]+"Ԫ";
							String praise = praiseNums[j]+"��";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);									
						}
						
						//������ѡ��Ʒ��ż�����
						System.out.print("��ѡ��������Ʒ��ţ�");
						int chooseDish = input.nextInt();
						System.out.print("��������������:");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish-1]+" "+number+"��";
						
						//���붩��������
						System.out.print("�����붩��������:");
						String name = input.next();
						
						//�����Ͳ�ʱ��
						System.out.print("�������Ͳ�ʱ�䣨10~20�����Ͳͣ�:");
						int time = input.nextInt();
						//������������������
						while (time<10 || time>20) {
							System.out.println("�Բ��������������������10~20֮���������");
							time = input.nextInt();
						}
						
						//�����Ͳ͵�ַ
						System.out.print("�������Ͳ͵�ַ��");
						String address = input.next();
						
						//����ͷ�
						double sumPrice = prices[chooseDish-1] * number;
						//�Ͳͷѣ����ͷ� �ﵽ50Ԫʱ����6Ԫ�Ͳͷ�
						double deliCharge = sumPrice>=50?0.0:6.0;
						
						//��ʾ������Ϣ
						System.out.println("���ͳɹ���");
						System.out.println("�������ǣ�"+dishMeg);
						System.out.println("�����ˣ�"+name);
						System.out.println("�Ͳ�ʱ�䣺"+time+"��");
						System.out.println("�Ͳ͵�ַ��"+address);
						System.out.println("�ͷѣ�"+sumPrice+",�Ͳͷ�"+deliCharge+"Ԫ");
						System.out.println("�ܽ�"+(sumPrice+deliCharge)+"Ԫ");
						
						//��������
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice;						
						
						break;
					}
				}
				
				//���û���ҵ�Ϊ�յ�λ�ã�����ʾ��Ϣ
				if (!isAdd) {
					System.out.println("�Բ�����Ĳʹ�������");
				}
				
				break;
			case 2:
				//2.�鿴�ʹ�
				System.out.println("****�鿴�ʹ�****");
				System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t״̬");
				//��������
				for (int i = 0; i < names.length; i++) {
					if (names[i]!=null) {					
						String time = times[i]+"��";
						String sumPrice = sumPrices[i]+"Ԫ";
						String state = states[i]==0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t\t"+sumPrice+"\t"+state);
						
					}
				}
				break;
            case 3:
            	//3.ǩ�ն���
            	System.out.println("****ǩ�ն���****");
            	//Ҫ���û�����һ��ǩ�յĶ�����
            	System.out.print("������Ҫǩ�յĶ����ţ�");
            	int signOrderID = input.nextInt();
            	boolean isFind = false; //��¼�Ƿ��ҵ�������������true���ҵ��ˣ�false��û�ҵ�
            	//�������������ţ�ѭ��������
            	for (int i = 0; i < names .length; i++) {
					/*1���ҵ���״̬������ɣ���ʾ�����ٴ�ǩ��
					 * 2���ҵ���״̬����Ԥ��������ǩ��
					 */
            		if (names[i]!=null && states[i]==1 && signOrderID==i+1) {
						System.out.println("�Բ�ȥ����ѡ��Ķ�����ǩ�գ������ٴ�ǩ�գ�");
						isFind = true;
						break;
					}else if (names[i]!=null && states[i]==0 && signOrderID==i+1) {
						states[i]=1; //״ֵ̬��Ϊ�����״̬
						System.out.println("����ǩ�ճɹ���");
						isFind = true;
						break;
					}            		
				}
            	//�����жϣ����û���ҵ�������������ʾû���ҵ�
            	if (!isFind) {
					System.out.println("�Բ�ȥ���������������ڣ�");
				}
				break;
            case 4:
            	//4.ɾ������
            	System.out.println("****ɾ������****");
            	//����Ҫɾ���Ķ������
            	System.out.print("��������Ҫɾ���Ķ����ţ�");
            	int delID = input.nextInt();
            	int delIndex = -1; //��¼ɾ���������±�
            	boolean isDelFind = false; //��¼�Ƿ��ҵ�Ҫɾ���Ķ���
            	//ѭ��������������
            	for (int i = 0; i < names.length; i++) {
					/*�ҵ��˶�������ǩ�գ�ִ��ɾ���������ټ���Ҫɾ���Ķ�����ţ�
					 * �ҵ��˶�����δǩ�գ���ʾ��Ϣ������ɾ��
					 */
            		if (names[i]!=null && states[i]==1 && delID==i+1) {
						delIndex = i;
						isDelFind = true;
						break;
					}else if (names[i]!=null && states[i]==0 && delID==i+1) {
						System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
						isDelFind = true;
						break;
					}
				}
            	//δ�ҵ��˶�������ʾ��Ϣ
            	if (!isDelFind) {
					System.out.println("�Բ��𣬴˶���������");
				}
            	
            	//ִ��ɾ������
            	if (delIndex!=-1) {
					//ɾ��������ѭ����λ������Ҫɾ����Ԫ�غ���һ����ʼ���������һ��Ԫ��������ǰ�ƶ�һλ
            		for (int i = delIndex+1; i <= names.length-1; i++) {
						names[i-1]=names[i];
						dishMegs[i-1]=dishMegs[i];
						times[i-1]=times[i];
						addresses[i-1]=addresses[i];
						states[i-1]=states[i];
					}
            		//���һλ���
            		names[names.length-1] = null;
            		dishMegs[dishMegs.length-1] = null;
            		times[times.length-1] = 0;
            		addresses[addresses.length-1] = null;
            		states[states.length-1] = 0;
            		
            		System.out.println("����ɾ���ɹ���");
            		
				}
				break;
            case 5:
            	//5.��Ҫ����
            	System.out.println("****��Ҫ����****");
            	//��ʾ�ɹ����޵Ĳ�Ʒ�б�
            	System.out.println("���\t��Ʒ��\t����\t������");
				for (int j = 0; j < dishNames.length; j++) {
					String price = prices[j]+"Ԫ";
					String praise = praiseNums[j]+"��";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);									
				}
            	//����Ҫ���޵Ĳ�Ʒ���
				System.out.print("������Ҫ���޵Ĳ�Ʒ��ţ�");
				int dishID = input.nextInt();
            	//����ŵĲ�Ʒ��������һ
				praiseNums[dishID-1]++;
            	//��ʾ
				System.out.println("���޳ɹ���");
				System.out.println(dishNames[dishID-1]+" "+praiseNums[dishID-1]+"��");
				break;
            case 6:
            	//6.�˳�ϵͳ
            	break;
			default:
				break;
			}
			//���û�����Ĺ��ܱ��Ϊ1~5֮�������ʱ���˳�ϵͳ
			if (choose>5 || choose<1) {
				break;
			}else{
			//��ʾ����0����
			System.out.print("����0���أ�");
			num = input.nextInt();
			}
		} while (num==0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
	}
}
