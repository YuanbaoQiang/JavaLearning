public class FamilyAccountTest {
    public static void main(String[] args){
        boolean isFalse = true;
        // ��ʼ���
        int balance = 10000;

        // ��¼�û�����֧���
        String details = "";

        while(isFalse){
            System.out.println("-----------------��ͥ��֧�������-----------------");
            System.out.println("\t\t\t\t1\t��֧��ϸ");
            System.out.println("\t\t\t\t2\t�Ǽ�����");
            System.out.println("\t\t\t\t3\t�Ǽ�֧��");
            System.out.println("\t\t\t\t4\t��\t��\n");
            System.out.print("\t\t\t\t��ѡ��(1-4)��");

            // ��ȡ�û���ѡ��1-4
            char selection = Utility.readMenuSelection();

            switch(selection){
                // ������ϸѡ��
                case '1':
                    //System.out.println("\t1\t��֧��ϸ");

                    System.out.println("-----------------��ǰ��֧��ϸ��¼-----------------");
                    System.out.println("��֧\t\t�˻����\t\t��֧���\t\t˵    ��");
                    System.out.println(details);
                    System.out.println("---------------------�Ǽ����---------------------\n");

                    break;

                // �Ǽ�����ѡ��
                case '2':
                    //System.out.println("\t2\t�Ǽ�����");
                    System.out.print("���������");
                    int addMoney = Utility.readNumber();
                    System.out.print("��������˵����");
                    String addInfo = Utility.readString();

                    // ����balance
                    balance += addMoney;

                    // ����details
                    details += ("����\t\t" + balance + "\t\t" + "+"+addMoney + "\t\t" + addInfo + "\n");

                    break;


                // �Ǽ�֧��ѡ��
                case '3':
                    //System.out.println("\t3\t�Ǽ�֧��");
                    System.out.print("����֧����");
                    int minusMoney = Utility.readNumber();
                    System.out.print("����֧��˵����");
                    String minusInfo = Utility.readString();

                    // ����balance
                    balance -= minusMoney;

                    // ����details
                    details += ("֧��\t\t" + balance + "\t\t" + "-"+minusMoney + "\t\t" + minusInfo + "\n");

                    break;

                // �˳�ѡ��
                case '4':
                    //System.out.println("\t4\t��\t��");
                    System.out.print("ȷ���Ƿ��˳���Y/N����");
                    char isExit =Utility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFalse = false;
                    }

                    break;
            }

        }
    }
}
