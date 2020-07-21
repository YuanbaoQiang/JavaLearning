public class FamilyAccount {
    public static void main(String[] args){
        boolean isFalse = true;
        // 用于记录用户的收入和支出的详情
        String details = "";
        // 定义初始余额
        int balance = 10000;

        while(isFalse){
            System.out.println("-----------------家庭收支记账软件-----------------\n");
            System.out.println("                  1 收支明细");
            System.out.println("                  2 登记收入");
            System.out.println("                  3 登记支出");
            System.out.println("                  4 退   出\n");
            System.out.print("                   请选择(1-4)：");

            // 获取用户的选择：1-4
            char selection = Utility.readMenuSelection();

            switch(selection){
                case '1':
                    // System.out.println("1 收支明细");
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println("收支\t\t账户金额\t\t收支金额\t\t说    明\n");
                    System.out.println(details);
                    System.out.println("---------------------登记完成---------------------");

                    break;
                case '2':
                    // System.out.println("2 登记收入");
                    System.out.print("本次收入金额：");
                    int money01 = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String info01 = Utility.readString();

                    // 处理balance
                    balance += money01;

                    // 处理details
                    details +=("收入\t\t" + balance + "\t\t" + +money01 + "\t\t" + info01 + "\n");

                    break;

                case '3':
                    // System.out.println("3 登记支出");
                    System.out.print("本次消费金额：");
                    int money02 = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String info02 = Utility.readString();

                    // 处理balance
                    balance -= money02;

                    // 处理details
                    details +=("收入\t\t" + balance + "\t\t" + -money02 + "\t\t" + info02 + "\n");



                    break;
                case '4':
                    // System.out.println("4 退   出");
                    System.out.print("确认是否退出（Y/N）：");
                    char isExit =Utility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFalse = false;
                    }


                    break;
            }
        }
    }
}
