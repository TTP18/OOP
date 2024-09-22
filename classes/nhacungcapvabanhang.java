
package classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class nhacungcapvabanhang {
    
            interface QuanLy {
                void them();
                void xoa();
                void sua();
                void tim();
                void xuat();
                void nhap();
                void DocFile();
                void GhiFile();
            }

            class NHACUNGCAP{
            private String ten;
            private String diachi;
            private String sodienthoai;
            private String manhacungcap;

            public NHACUNGCAP(){
                ten="";
                diachi=" ";
                sodienthoai=" ";
                manhacungcap="";
            }

            public NHACUNGCAP(String ten, String diachi, String sodienthoai, String manhacungcap){
                this.ten=ten;
                this.diachi=diachi;
                this.sodienthoai=sodienthoai;
                this.manhacungcap=manhacungcap;
            }

            public String getTen(){ return ten; }
            public String getSodienthoai(){ return sodienthoai; }
            public String getDiachi(){ return diachi; }
            public String getManhacungcap(){ return manhacungcap; }
            public void setTen(String ten){ this.ten=ten; }
            public void setDiachi(String diachi){ this.diachi=diachi; }
            public void setSodienthoai(String sodienthoai){ this.sodienthoai=sodienthoai; }
            public void setManhacungcap(String manhacungcap){ this.manhacungcap=manhacungcap; }
            public void nhap() {
                Scanner sc = new Scanner(System.in);

                // Nhập tên nhà cung cấp
                System.out.println("Nhap ten nha cung cap: ");
                ten = sc.nextLine();
                while (ten.isEmpty()) {
                    System.out.println("Ten nha cung cap khong đuoc đe trong. Vui long nhap lai: ");
                    ten = sc.nextLine();
                }

                // Nhập địa chỉ nhà cung cấp
                System.out.println("Nhap dia chi nha cung cap: ");
                diachi = sc.nextLine();
                while (diachi.isEmpty()) {
                    System.out.println("Dia chi nha cung cap khong duoc de trong. Vui long nhap lai: ");
                    diachi = sc.nextLine();
                }

                // Nhập số điện thoại nhà cung cấp
                System.out.println("Nhap so dien thoai nha cung cap: ");
                sodienthoai = sc.nextLine();
                while (!sodienthoai.matches("\\d{10}")) // kiểm tra xem chỉ có 10 chữ so
                {
                    System.out.println("So dien thoai nha cung cap chi chua cac chu so co 10 chu so. Vui long nhap lai: ");
                    sodienthoai = sc.nextLine();
                }

                // Nhập mã nhà cung cấp
                System.out.println("Nhap ma nha cung cap: ");
                manhacungcap = sc.nextLine();
                while (manhacungcap.isEmpty()) {
                    System.out.println("Ma nha cung cap khong hop le. Vui long nhap lai: ");
                    manhacungcap = sc.nextLine();
                }

                System.out.println("-----------------------------------------------");
            }

            public void xuat(){
                System.out.println("Ten nha cung cap: "+ten);
                System.out.println("Dia chi nha cung cap:"+diachi);
                System.out.println("So dien thoai nha cung cap:  "+sodienthoai);
                System.out.println("Ma nha cung cap: "+manhacungcap);
            }
        }

        public class DSNHACUNGCAP implements QuanLy{
            private NHACUNGCAP dsnhacungcap[];
            int n;
            public DSNHACUNGCAP(){
                n=0;
                dsnhacungcap=new NHACUNGCAP[0];
            }
            public DSNHACUNGCAP(int n, NHACUNGCAP ds[])
            {
                this.n=n;
                this.dsnhacungcap= Arrays.copyOf(ds,ds.length);
            }

            @Override
            public void nhap()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap so luong nha cung cap : ");
                n=sc.nextInt();


                dsnhacungcap=new NHACUNGCAP[n];
                for(int i=0;i<n;i++)
                {
                    dsnhacungcap[i]=new NHACUNGCAP();
                    dsnhacungcap[i].nhap();
                }
            }

            @Override
            public void xuat()
            {
                System.out.println("--------------------------------------------------------Danh sach nha cung cap---------------------------------------------------------------");
                System.out.println("");
                System.out.printf("%-4s%-20s%-25s%-15s%-35s\n","STT","Ma nha cung cap","Ten nha cung cap","So dien thoai","Dia chi");
                for(int i=0;i<n;i++)
                {
                    System.out.printf("%-4d%-20s%-25s%-15s%-35s\n",i+1,dsnhacungcap[i].getManhacungcap(),dsnhacungcap[i].getTen(),dsnhacungcap[i].getSodienthoai(),dsnhacungcap[i].getDiachi());
                }
            }


            //XOA
            @Override
            public void xoa()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap nha cung cap can xoa :");
                String ten=sc.nextLine();
                for(int i=0;i<n;i++)
                {
                    if(dsnhacungcap[i].getTen().equals(ten))
                    {
                        for(int j=i;j<n-1;j++)
                        {
                            dsnhacungcap[j]=dsnhacungcap[j+1];
                        }
                        n--;
                        break;
                    }
                }
            }


            //THEM
            @Override
            public void them()
            {
                dsnhacungcap=Arrays.copyOf(this.dsnhacungcap,n+1);
                dsnhacungcap[n]=new NHACUNGCAP();
                System.out.println("-----~~~~~~~~~~THEMNHACUNGCAP~~~~~~~~~~-----");
                dsnhacungcap[n].nhap();
                n++;
            }

            //TIM
            @Override
            public void tim()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap nha cung cap can tim: ");
                String Tenkhach=sc.nextLine();
                for(int i=0;i<n;i++)
                {
                    if(dsnhacungcap[i].getTen().equals(Tenkhach))
                    {
                        dsnhacungcap[i].xuat();
                    }
                }
            }

            //SUA
            @Override
            public void sua()
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap nha cung cap can sua: ");
                String Tennhacungcap = sc.nextLine();
                System.out.println("Nhap nha cung cap moi: ");
                String nhacungcapmoi=sc.nextLine();
                System.out.println("Nhap dia chi: ");
                String diachi = sc.nextLine();
                System.out.println("Nhap so dien thoai: ");
                String dienthoai = sc.nextLine();
                System.out.println("nhap ma nha cung cap: ");
                String manhacungcap=sc.nextLine();

                for(int i=0;i<n;i++)
                {
                    if(dsnhacungcap[i].getTen().equals(Tennhacungcap))
                    {
                        dsnhacungcap[i].setTen(Tennhacungcap);
                        dsnhacungcap[i].setDiachi(diachi);
                        dsnhacungcap[i].setSodienthoai(dienthoai);
                        dsnhacungcap[i].setManhacungcap(manhacungcap);
                    }
                }
            }

            @Override
            //Luu va lay du lieu tu file
            public void DocFile(){
               
                
                try {
                    BufferedReader input = new BufferedReader(new FileReader("c:/VScode-Java/Java/doanoop/data/inputnhacungcap.txt"));
                    String line = input.readLine();
                    while (line != null) {
                        String[] arr = line.split(",");

                        // Kiểm tra xem có đủ thông tin để tạo đối tượng KhachHang không
                        if (arr.length == 4) {
                            String tennhacungcap = arr[0].trim();
                            String diachi = arr[1].trim();
                            String sodienthoainhacungcap = arr[2].trim();
                            String manhacungcap = arr[3].trim();

                            // Tạo đối tượng NHACUNGCAP và thêm vào mảng ds
                            NHACUNGCAP nhacungcap = new NHACUNGCAP(tennhacungcap, diachi, sodienthoainhacungcap, manhacungcap);
                            dsnhacungcap = Arrays.copyOf(dsnhacungcap, n + 1);
                            dsnhacungcap[n] = nhacungcap;
                            n++;
                        }

                        //Xuat du lieu
                        // for (int i = 0; i<arr.length; i++)
                        //     System.out.println(arr[i]);

                        line = input.readLine();
                    }
                    input.close();
                    System.out.println("Doc file vao mang danh sach nha cung cap thanh cong !");
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void GhiFile(){

                


                try (FileWriter fw = new FileWriter("c:/VScode-Java/Java/doanoop/data/outputnhacungcap.txt")) {
                    for ( int i = 0 ; i<n ; i++ ){
                        NHACUNGCAP nhacungcap = dsnhacungcap[i];
                        fw.write(nhacungcap.getTen() +","+ nhacungcap.getDiachi() +","+ nhacungcap.getSodienthoai()+","+ nhacungcap.getManhacungcap());
                        fw.write(System.lineSeparator());
                    }
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }



        }

        class BANHANG{
            private static int tongsoluong;
            private int soluong;
            private double giaban;
            private String ngayban;

            public BANHANG(){
                soluong=0;
                giaban=0;
                ngayban=" ";
            }

            public BANHANG(int soluong, double giaban, String ngayban){
                this.soluong=soluong;
                this.giaban=giaban;
                this.ngayban=ngayban;
                tongsoluong+=soluong;
            }

            public int getSoluong(){ return soluong; }

            public static int getTongsoluong() {
                return tongsoluong;
            }
            public double getGiaban(){ return giaban; }

            public String getNgayban(){ return ngayban;}

            public void setSoluong(int soluong){
                tongsoluong -= this.soluong; // cho chính xác
                this.soluong=soluong;
                tongsoluong += soluong;
            }

            public void setGiaban(double giaban){ this.giaban=giaban; }

            public void setNgayban(String ngayban){ this.ngayban=ngayban; }

            public void nhap() {
                Scanner sc = new Scanner(System.in);

                // Kiểm tra và yêu cầu nhập số lượng hợp lệ
                System.out.print("Nhap so luong (so nguyen duong): ");
                while (!sc.hasNextInt()) {
                    System.out.println("So luong phai la so nguyen duong. Vui long nhap lai.");
                    System.out.print("Nhập số lượng (số nguyên dương): ");
                    sc.next();
                }
                soluong = sc.nextInt();
                while (soluong <= 0) {
                    System.out.println("So luong phai la so nguyen duong. Vui long nhap lai.");
                    System.out.print("Nhap so luong (so nguyen duong): ");
                    soluong = sc.nextInt();
                }
                tongsoluong += soluong;

                // Kiểm tra và yêu cầu nhập giá trị hợp lệ
                System.out.print("Nhap gia (so thuc duong): ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Gia phai la so thuc duong. Vui lòng nhap lai.");
                    System.out.print("Nhap gia (so thuc duong): ");
                    sc.next();
                }
                giaban = sc.nextDouble();
                while (giaban <= 0) {
                    System.out.println("Gia phai la so thuc duong. Vui lòng nhap lai.");
                    System.out.print("Nhap gia (so thuc duong): ");
                    giaban = sc.nextDouble();
                }

                // Kiểm tra và yêu cầu nhập ngày hợp lệ
                System.out.print("Nhap ngay ban (dd/mm/yyyy): ");
                String ngayban = sc.next();
                while (!isValidDate(ngayban)) {
                    System.out.println("Ngay khong hop le. Vui long nhap lai theo dinh dang dd/mm/yyyy.");
                    System.out.print("Nhap ngay ban (dd/mm/yyyy): ");
                    ngayban = sc.nextLine();
                }
                this.ngayban = ngayban;

                System.out.println("---------------------------------------------");
            }
            private boolean isValidDate(String date) {
                // Kiểm tra định dạng ngày dd/mm/yyyy
                String[] parts = date.split("/");
                if (parts.length != 3) {
                    return false;
                }

                int day, month, year;
                try {
                    day = Integer.parseInt(parts[0]);
                    month = Integer.parseInt(parts[1]);
                    year = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    return false;
                }

                // Kiểm tra ngày, tháng, năm hợp lệ
                boolean isValid = true;
                if (year < 1000 || year > 9999) {
                    isValid = false;
                }
                if (month < 1 || month > 12) {
                    isValid = false;
                }
                if (day < 1 || day > getDaysInMonth(month, year)) {
                    isValid = false;
                }

                return isValid;
            }
            private int getDaysInMonth(int month, int year) {
               
                int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                if (month == 2 && isLeapYear(year)) {
                    return 29;
                }
                return daysInMonth[month - 1];
            }

            private boolean isLeapYear(int year) {
                // Kiểm tra năm nhuận
                return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            }


            public void xuat(){
                System.out.println("so luong: "+soluong);
                System.out.println("gia: "+giaban);
                System.out.println("ngay ban: "+ngayban);
                System.out.println("tong so luong ban hang:"+tongsoluong);
                System.out.println("---------------------------------------------");
            }
        }

}
