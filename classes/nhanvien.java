
package classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class nhanvien {

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
        
        abstract public class nguoi {
            protected String ten ;
            protected String sodienthoai ;
            protected String ngaysinh ;
            protected String diachi ;
            public nguoi (){
                ten = sodienthoai = ngaysinh = diachi = "" ;
            }
            public nguoi ( String ten , String sodienthoai , String ngaysinh , String diachi ){
                this.ten = ten ;
                this.sodienthoai = sodienthoai ;
                this.ngaysinh = ngaysinh ;
                this.diachi = diachi ;
            }
            public void setTen ( String ten ){
                this.ten = ten ;
            }
            public String getTen (){
                return this.ten ;
            }
            public void setSodienthoai ( String sodienthoai ){
                this.sodienthoai = sodienthoai ;
            }
            public String getSodienthoai () {
                return this.sodienthoai ;
            }
            public void setNgaysinh ( String ngaysinh ){
                this.ngaysinh = ngaysinh ;
            }
            public String getNgaysinh (){
                return this.ngaysinh ;
            }
            public void setDiachi ( String diachi ){
                this.diachi = diachi ;
            }
            public String getDiachi (){
                return this.diachi ;
            }

            public abstract void nhap() ;



            public abstract void xuat() ;



        }

        class Nhanvien extends nguoi {
            private String manhanvien ;
            private int luong ;
            private String ngayvaolam ;
            public Nhanvien (){
                super() ;
                manhanvien = ngayvaolam = "" ;
                luong = 0 ;
            }
            public Nhanvien (String ten , String sodienthoai , String ngaysinh , String diachi , String manhanvien , int luong , String ngayvaolam ){
                super(ten, sodienthoai, ngaysinh, diachi) ;
                this.manhanvien = manhanvien ;
                this.luong = luong ;
                this.ngayvaolam = ngayvaolam ;
            }

            public void setManhanvien ( String manhanvien ){
                this.manhanvien = manhanvien ;
            }
            public String getManhanvien (){
                return this.manhanvien ;
            }
            public void setLuong ( int luong ){
                this.luong = luong ;
            }
            public int getLuong (){
                return this.luong ;
            }
            public void setNgayvaolam ( String ngayvaolam ){
                this.ngayvaolam = ngayvaolam ;
            }
            public String getNgayvaolam (){
                return this.ngayvaolam ;
            }
            @Override
            public void nhap(){
                Scanner sc = new Scanner(System.in) ;
                System.out.println(" Nhap Ten : ") ;
                ten = sc.nextLine() ;
                while (!isValidTen(ten)) {
                    System.out.println("Ten khong duoc chua chu so. Vui long nhap lai.");
                    System.out.println("Nhap Ten: ");
                    ten = sc.nextLine();
                }

                System.out.println(" Nhap So Dien Thoai : ") ;
                sodienthoai = sc.nextLine() ;
                while (!isValidSoDienThoai(sodienthoai)) {
                    System.out.println("So dien thoai khong hop le. Vui long nhap lai.");
                    System.out.println("Nhap So dien thoai: ");
                    sodienthoai = sc.nextLine();
                }

                System.out.println(" Nhap Ngay sinh : ") ;
                ngaysinh = sc.nextLine() ;
                while (!isValidNgay(ngaysinh)) {
                    System.out.println("Nhap sai dinh dang ngay sinh. Vui long nhap lai.");
                    System.out.println("Nhap Ngay sinh (dd/mm/yyyy): ");
                    ngaysinh = sc.nextLine();
                }

                System.out.println(" Nhap Dia Chi : ") ;
                diachi = sc.nextLine() ;

                System.out.println(" Nhap Ma Nhan Vien : ") ;
                manhanvien = sc.nextLine() ;
                while (!isValidMaNhanVien(manhanvien)){
                    System.err.println("Nhap sai dinh dang ma sinh vien. Vui long nhap lai ");
                    System.out.println("Nhap ma sinh vien");
                    manhanvien=sc.nextLine();
                }

                System.out.println(" Nhap Luong : ") ;
                while (!sc.hasNextInt()) {
                    System.out.println("Nhap sai dinh dang luong. Vui long nhap lai.");
                    System.out.println("Nhap luong: ");
                    sc.next();
                }
                luong = sc.nextInt();
                sc.nextLine();

                System.out.println(" Nhap Ngay Vao Lam : ");
                ngayvaolam = sc.nextLine() ;
                while (!isValidNgay(ngayvaolam)) {
                    System.out.println("Ngay vao lam khong hop le. Vui long nhap lai.");
                    System.out.println("Nhap Ngay sinh (dd/mm/yyyy): ");
                    ngayvaolam = sc.nextLine();
                }
            }

            private boolean isValidTen(String ten) {
                return ten.matches("\\D+") && ten.length() <= 20;
            }

            private boolean isValidSoDienThoai(String sodienthoai) {
                return sodienthoai.matches("\\d{10}");
            }

            private boolean isValidNgay(String ngaySinh) {
                return ngaySinh.matches("\\d{2}/\\d{2}/\\d{4}");
            }

            private boolean isValidMaNhanVien(String manhanvien) {
                return manhanvien.matches("\\d{10}") ;
            }






            @Override
            public void xuat (){
                System.out.println(" Ten : " + ten);
                System.out.println(" So dien thoai : " + sodienthoai);
                System.out.println(" Ngay sinh : " + ngaysinh);
                System.out.println(" Dia chi : " + diachi);
                System.out.println(" Ma nhan vien : " + manhanvien);
                System.out.println(" Luong : " + luong);
                System.out.println(" Ngay vao lam : " + ngayvaolam);
            }
        }



        public class DSNhanVien implements QuanLy {
            private Nhanvien[] dsnv;
            private int n;

            public DSNhanVien() {
                dsnv = new Nhanvien[0];
                n = 0;
            }

            public DSNhanVien ( Nhanvien[] dsnv , int n ){
                this.dsnv = Arrays.copyOf(dsnv , dsnv.length) ;
                this.n = n ;
            }


            public boolean checkIdNhanVien(String idNhanVien)
            {
                for(int i=0;i<dsnv.length;i++)
                {
                    if(dsnv[i].getManhanvien().equals(idNhanVien))
                    {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public void nhap (){
                System.out.println("Nhap so luong nhan vien :");
                Scanner sc = new Scanner ( System.in ) ;
                n = sc.nextInt() ;
                dsnv = new Nhanvien[n] ;
                for ( int i = 0 ; i<n ; i++ ){
                    dsnv[i] = new Nhanvien() ;
                    dsnv[i].nhap() ;
                    System.out.println("---------------------------");

                }
            }

            @Override
            public void them() {
                dsnv = Arrays.copyOf(dsnv, n + 1);
                dsnv[n] = new Nhanvien();
                dsnv[n].nhap();
                n++;
            }

            @Override
            public void xoa() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap ma nhan vien can xoa :");
                String masinhviencanxoa = sc.nextLine();
                for (int i = 0; i < n; i++) {
                    if (dsnv[i].getManhanvien().equals(masinhviencanxoa)) {
                        for (int j = i; j < n - 1; j++) {
                            dsnv[j] = dsnv[j + 1];
                        }
                        dsnv = Arrays.copyOf(dsnv, n - 1);
                        n--;
                        break;
                    }
                }
            }

            @Override
            public void sua() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap ma nhan vien can sua :");
                String masinhviencansua = sc.nextLine();
                for (int i = 0; i < n; i++) {
                    if (dsnv[i].getManhanvien().equals(masinhviencansua)) {

                        System.out.println("Thong tin cu cua nhan vien:");
                        dsnv[i].xuat();
                        System.out.println("---------------------------");


                        System.out.println("Nhap thong tin moi cho nhan vien:");
                        System.out.print("Nhap ten: ");
                        String tenMoi = sc.nextLine();
                        dsnv[i].setTen(tenMoi);

                        System.out.println("Nhap so dien thoai: ");
                        String sdtMoi = sc.nextLine();
                        dsnv[i].setSodienthoai(sdtMoi);

                        System.out.println("Nhap ngay sinh: ");
                        String ngaysinhMoi = sc.nextLine();
                        dsnv[i].setNgaysinh(ngaysinhMoi);

                        System.out.println("Nhap dia chi: ");
                        String diachiMoi = sc.nextLine();
                        dsnv[i].setDiachi(diachiMoi);

                        System.out.println("Nhap luong: ");
                        int luongMoi = sc.nextInt();
                        dsnv[i].setLuong(luongMoi);

                        sc.nextLine();
                        System.out.println("Nhap ngay vao lam: ");
                        String ngayvaolamMoi = sc.nextLine();
                        dsnv[i].setNgayvaolam(ngayvaolamMoi);
                        System.out.println("---------------------------");


                        System.out.println("Thong tin sau khi sua:");
                        dsnv[i].xuat();
                        break;
                    }
                }
            }

            @Override
            public void tim() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap ma nhan vien can tim kiem :");
                String manhanviencantim = sc.nextLine();
                for (int i = 0; i < n; i++) {
                    if (dsnv[i].getManhanvien().equals(manhanviencantim)) {
                        dsnv[i].xuat();
                    }
                }
            }

            @Override
            public void xuat() {
                System.out.println("--------------------------------------------------------Danh sach nhan vien---------------------------------------------------------------");
                System.out.println("");
                System.out.printf("%-4s%-15s%-20s%-15s%-15s%-35s%-15s%s\n","STT","Ma nhan vien","Ten nhan vien","So dien thoai","Ngay sinh","Dia chi","Ngay vao lam","Luong");
                for(int i=0;i<n;i++)
                {
                    System.out.printf("%-4d%-15s%-20s%-15s%-15s%-35s%-15s%d\n",i+1,dsnv[i].getManhanvien(),dsnv[i].ten,dsnv[i].sodienthoai,dsnv[i].ngaysinh,dsnv[i].diachi,dsnv[i].getNgayvaolam(),dsnv[i].getLuong());
                }
            }


            @Override
            public void DocFile() {
             
                
                try {
                  
                    BufferedReader input = new BufferedReader(new FileReader("c:/VScode-Java/Java/doanoop/data/input.txt"));
                    String line = input.readLine();

                    while (line != null) {
                        String[] arr = line.split(",");

                        // Kiểm tra xem có đủ thông tin để tạo đối tượng Nhanvien không
                        if (arr.length == 7) {
                            String ten = arr[0].trim();
                            String sodienthoai = arr[1].trim();
                            String ngaysinh = arr[2].trim();
                            String diachi = arr[3].trim();
                            String manhanvien = arr[4].trim();
                            int luong = Integer.parseInt(arr[5].trim());
                            String ngayvaolam = arr[6].trim();

                            // Tạo đối tượng Nhanvien và thêm vào mảng dsnv
                            Nhanvien nv = new Nhanvien(ten, sodienthoai, ngaysinh, diachi, manhanvien, luong, ngayvaolam);
                            dsnv = Arrays.copyOf(dsnv, n + 1);
                            dsnv[n] = nv;
                            n++;
                        }

                        line = input.readLine();
                    }

                    input.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void GhiFile(){

               
                


                try (FileWriter fw = new FileWriter("c:/VScode-Java/Java/doanoop/data/output.txt")) {
                    for ( int i = 0 ; i<n ; i++ ){
                        Nhanvien nv = dsnv[i];
                        fw.write(nv.getTen() + "," + nv.getSodienthoai() + "," + nv.getNgaysinh() + "," +
                                nv.getDiachi() + "," + nv.getManhanvien() + "," + nv.getLuong() + "," +
                                nv.getNgayvaolam());
                        fw.write(System.lineSeparator());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

}
