public class FamilyAccount {
    public static void main(String[] args){
        boolean isFalse = true;
        // ���ڼ�¼�û��������֧��������
        String details = "";
        // �����ʼ���
        int balance = 10000;

        while(isFalse){
            System.out.println("-----------------��ͥ��֧�������-----------------\n");
            System.out.println("                  1 ��֧��ϸ");
            System.out.println("                  2 �Ǽ�����");
            System.out.println("                  3 �Ǽ�֧��");
            System.out.println("                  4 ��   ��\n");
            System.out.print("                   ��ѡ��(1-4)��");

            // ��ȡ�û���ѡ��1-4
            char selection = Utility.readMenuSelection();

            switch(selection){
                case '1':
                    // System.out.println("1 ��֧��ϸ");
                    System.out.println("-----------------��ǰ��֧��ϸ��¼-----------------");
                    System.out.println("��֧\t\t�˻����\t\t��֧���\t\t˵    ��\n");
                    System.out.println(details);
                    System.out.println("---------------------�Ǽ����---------------------");

                    break;
                case '2':
                    // System.out.println("2 �Ǽ�����");
                    System.out.print("���������");
                    int money01 = Utility.readNumber();
                    System.out.print("��������˵����");
                    String info01 = Utility.readString();

                    // ����balance
                    balance += money01;

                    // ����details
                    details +=("����\t\t" + balance + "\t\t" + +money01 + "\t\t" + info01 + "\n");

                    break;

                case '3':
                    // System.out.println("3 �Ǽ�֧��");
                    System.out.print("�������ѽ�");
                    int money02 = Utility.readNumber();
                    System.out.print("��������˵����");
                    String info02 = Utility.readString();

                    // ����balance
                    balance -= money02;

                    // ����details
                    details +=("����\t\t" + balance + "\t\t" + -money02 + "\t\t" + info02 + "\n");



                    break;
                case '4':
                    // System.out.println("4 ��   ��");
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
