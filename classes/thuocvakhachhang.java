
package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class thuocvakhachhang {

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

        abstract class nguoi {
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


        //THUOC VA KHACH HANG
        class THUOC{
            private String tenthuoc;
            private double gia;
            private int soluong;
            public THUOC(){
                tenthuoc = "";
                gia = 0;
                soluong = 0;
            }
            public THUOC(String tenthuoc, double gia, int soluong){
                this.tenthuoc = tenthuoc;
                this.gia = gia;
                this.soluong = soluong;
            }

            // public abstract void chucnang();

            public String getTenthuoc(){
                return tenthuoc;
            }
            public double getGia(){
                return gia;
            }
            public int getSoluong(){
                return soluong;
            }
            public void setTenthuoc(String tenthuoc){
                this.tenthuoc = tenthuoc;
            }
            public void setGia(double gia){
                this.gia = gia;
            }
            public void setSoluong(int soluong){
                this.soluong = soluong;
            }


            //KIEM TRA INPUT
            private boolean isValidTenthuoc(String tenthuoc) {
                return tenthuoc.matches("\\D+") && tenthuoc.length() <= 50;
            }


            private boolean isValidGiathuoc(Double gia) {
                return !Double.isNaN(gia);
            }

            private boolean isValidSoluong(int soluong) {
                return soluong >= 0 && soluong % 1 ==0;
            }
            //
            public String phanLoai()
            {
                return "";
            }

            public void nhap(){
                Scanner sc=new Scanner(System.in);
                //tenthuoc
                System.out.println("Nhap ten thuoc : ");
                tenthuoc=sc.nextLine();
                while(!isValidTenthuoc(tenthuoc)){
                    System.out.println("Ten thuoc khong hop le , vui long nhap lai !");
                    System.out.println("Nhap ten thuoc : ");
                    tenthuoc=sc.nextLine();
                }

                //giathuoc
                String deleteEnter ;
                System.out.println("Nhap gia : ");
                gia=sc.nextDouble();
                while(!isValidGiathuoc(gia)){
                    System.out.println("Gia khong hop le , vui long nhap lai !");
                    System.out.println("Nhap gia : ");
                    gia=sc.nextDouble();
                }

                //soluong
                deleteEnter = sc.nextLine();
                System.out.println("Nhap soluong : ");
                soluong=sc.nextInt();
                while(!isValidSoluong(soluong)){
                    System.out.println("So luong khong hop le , vui long nhap lai !");
                    System.out.println("Nhap soluong : ");
                    soluong=sc.nextInt();
                }

                // System.out.println("----------------------------------------------------------------");
            }
            public void xuat(){
                System.out.println("    ");
                System.out.println("---------------~~~~~~~~~~THUOC~~~~~~~~~~---------------");
                System.out.println("Tenthuoc : "+tenthuoc);
                System.out.println("Gia : "+gia);
                System.out.println("Soluong : "+soluong);
            }
        }


        class tpchucnang extends THUOC{
            private String congdung;
            public tpchucnang(){
                super();
                congdung="";
            }
            public tpchucnang(String tenthuoc, double gia, int soluong,String congdung){
                super(tenthuoc, gia, soluong);
                this.congdung=congdung;
            }
            public void setcongdung(String congdung){
                this.congdung=congdung;
            }
            public String getcongdung(){
                return this.congdung;
            }
            @Override
            public String phanLoai()
            {
                return "Thuc pham chuc nang";
            }



            //Kiem tra input

            private boolean isValidcongdung(String congdung) {
                return congdung.matches("\\D+") && congdung.length() <= 30;
            }

            public void nhap(){
                Scanner sc = new Scanner(System.in);
                super.nhap();
                System.out.println("Nhap Cong dung: ");
                congdung=sc.nextLine();
                while(!isValidcongdung(congdung)){
                    System.out.println("Cong dung khong hop le , vui long nhap lai !");
                    System.out.println("Nhap Cong dung: ");
                    congdung = sc.nextLine();
                }

            }

            public void xuat(){
                super.xuat();
                System.out.println("Cong dung: "+congdung);
            }
        }

        class thuocdactri extends THUOC{
            private String chucnang;
            public thuocdactri(){
                super();
                chucnang="";
            }
            public thuocdactri(String tenthuoc, double gia, int soluong, String chucnang)
            {
                super(tenthuoc, gia, soluong);
                this.chucnang=chucnang;
            }

            public void setChucnang(String chucnang)
            {
                this.chucnang=chucnang;
            }
            public String getChucnang(){
                return chucnang;
            }
            @Override
            public String phanLoai()
            {
                return "Thuoc dac tri";
            }



            //Kiem tra input

            private boolean isValidChucnang(String chucnang) {
                return chucnang.matches("\\D+") && chucnang.length() <= 50;
            }


            public void nhap()
            {
                Scanner sc = new Scanner(System.in);
                super.nhap();
                System.out.println("Nhap chuc nang:");
                chucnang=sc.nextLine();
                while(!isValidChucnang(chucnang)){
                    System.out.println("Chuc nang khong hop le , vui long nhap lai !");
                    System.out.println("Nhap chuc nang:");
                    chucnang = sc.nextLine();
                }
            }

            public void xuat()
            {
                super.xuat();
                System.out.println("Chuc nang: "+chucnang);
            }

        }
        public class DSTHUOC implements QuanLy
        {
            THUOC dsthuoc [];
            int n;
            public DSTHUOC(){
                n=0;
                dsthuoc=new THUOC[0];
            }
            public DSTHUOC(int n, THUOC ds[])
            {
                this.n=n;
                this.dsthuoc=Arrays.copyOf(ds,ds.length);
            }

            public boolean checkTenThuoc(String tenThuoc)
            {
                for(int i=0;i<dsthuoc.length;i++)
                {
                    if(tenThuoc.equals(dsthuoc[i].getTenthuoc()))
                    {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public void nhap()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap so luong :");
                n=sc.nextInt();
                dsthuoc=new THUOC[n];
                for(int i=0;i<n;i++)
                {
                    int luachon;
                    System.out.println(" ----------~~~~~PHAN-LOAI-THUOC~~~~~---------- ");
                    System.out.println("1.Thuc Pham Chuc Nang");
                    System.out.println("2.Thuoc Dac Tri");
                    System.out.println("Vui long nhap lua chon cua ban : ");
                    luachon=sc.nextInt();
                    if(luachon==1)
                    {
                        dsthuoc[i]=new tpchucnang();
                    }
                    else if(luachon==2){
                        dsthuoc[i]=new thuocdactri();
                    }
                    while(luachon !=1 && luachon !=2){
                        System.out.println("Lua chon cua ban khong hop le , vui long nhap lai :");
                        luachon=sc.nextInt();
                        if(luachon==1)
                        {
                            dsthuoc[i]=new tpchucnang();
                        }
                        else if(luachon==2){
                            dsthuoc[i]=new thuocdactri();
                        }
                    }

                    dsthuoc[i].nhap(); 
                }
            }


            @Override
            public void xuat()
            {
                // for(int i=0;i<n;i++)
                // {
                //     dsthuoc[i].xuat();
                // }

                System.out.println("--------------------------------------------------------Danh sach thuoc---------------------------------------------------------------");

                System.out.format(" %-10s %-30s %-30s %-10s %-10s %-20s\n", "STT","Ten thuoc","Phan loai", "So luong", "Don gia","Chuc nang");
                System.out.println("=".repeat(120));

                for(int i=0;i<n;i++)
                {
                    if(dsthuoc[i] instanceof thuocdactri){
                        thuocdactri tdt = (thuocdactri)dsthuoc[i];
                        System.out.format(" %-10s %-30s %-30s %-10s %-10s %-20s\n", i+1 ,tdt.getTenthuoc(),tdt.phanLoai(), tdt.getSoluong(),tdt.getGia(),tdt.getChucnang());
                    }

                    if(dsthuoc[i] instanceof tpchucnang){
                        tpchucnang tpcn = (tpchucnang)dsthuoc[i];
                        System.out.format(" %-10s %-30s %-30s %-10s %-10s %-20s\n", i+1 ,tpcn.getTenthuoc(),tpcn.phanLoai(), tpcn.getSoluong(),tpcn.getGia(),tpcn.getcongdung());
                    }



                    // System.out.format(" %-10s %-30s %-10s %-10s\n", i+1 ,dsthuoc[i].getTenthuoc(), dsthuoc[i].getSoluong(),dsthuoc[i].getGia());
                }
            }

            //XOA
            @Override
            public void xoa()
            {
                Scanner sc=new Scanner(System.in);
                String Tenthuoc;
                System.out.println("Nhap ten thuoc can xoa :");
                Tenthuoc=sc.nextLine();
                for(int i=0;i<n;i++)
                {
                    if(dsthuoc[i].getTenthuoc().equals(Tenthuoc))
                    {
                        for(int j=i;j<n-1;j++)
                        {
                            dsthuoc[j]=dsthuoc[j+1];
                        }
                        dsthuoc=Arrays.copyOf(dsthuoc,n);
                        n--;
                    }
                }
            }

            //THEM
            @Override
            public void them()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap ten thuoc can them :");
                String Tenthuoc=sc.next();
                System.out.println("Nhap so luong can them :");
                int soluong=sc.nextInt();
                for(int i=0;i<n;i++)
                {
                    if(dsthuoc[i].getTenthuoc().equals(Tenthuoc))
                    {
                        int slg = soluong+ dsthuoc[i].getSoluong();
                        dsthuoc[i].setSoluong(slg);
                    }
                }
            }
            public void themthuocmoi()
            {
                Scanner sc=new Scanner(System.in);
                dsthuoc=Arrays.copyOf(dsthuoc,n+1);
                dsthuoc[n]=new THUOC();

                int luachon;
                System.out.println(" ----------~~~~~PHAN-LOAI-THUOC~~~~~---------- ");
                System.out.println("1.Thuc Pham Chuc Nang");
                System.out.println("2.Thuoc Dac Tri");
                System.out.println("Vui long nhap lua chon cua ban : ");
                luachon=sc.nextInt();
                if(luachon==1)
                {
                    dsthuoc[n]=new tpchucnang();
                }
                else if(luachon==2){
                    dsthuoc[n]=new thuocdactri();
                }
                while(luachon !=1 && luachon !=2){
                    System.out.println("Lua chon cua ban khong hop le , vui long nhap lai :");
                    luachon=sc.nextInt();
                    if(luachon==1)
                    {
                        dsthuoc[n]=new tpchucnang();
                    }
                    else if(luachon==2){
                        dsthuoc[n]=new thuocdactri();
                    }
                }

                dsthuoc[n].nhap(); 
                n++;
            }


            //KIEM TRA INPUT
            private boolean isValidTenthuoc(String tenthuoc) {
                return tenthuoc.matches("\\D+") && tenthuoc.length() <= 50;
            }


            private boolean isValidGiathuoc(Double gia) {
                return !Double.isNaN(gia);
            }

            private boolean isValidSoluong(int soluong) {
                return soluong >= 0 && soluong % 1 ==0;
            }
            //

            //SUA
            @Override
            public void sua()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap ten thuoc can sua :");
                String Tenthuoc=sc.nextLine();
                while(!isValidTenthuoc(Tenthuoc)){
                    System.out.println("Ten thuoc khong hop le , vui long nhap lai : ");
                    Tenthuoc=sc.nextLine();
                }

                var checkTenThuoc=false;
                for(int i=0;i<n;i++)
                {
                    if(dsthuoc[i].getTenthuoc().equals(Tenthuoc))
                    {
                        checkTenThuoc=true;
                    }

                }

                while(checkTenThuoc==false){
                    System.out.println("Khong ton tai thuoc nay !");
                    System.out.println("Nhap ten thuoc : ");
                    Tenthuoc=sc.nextLine();
                }


                System.out.println("Nhap ten thuoc moi :");
                String tenthuocmoi=sc.nextLine();
                while(!isValidTenthuoc(tenthuocmoi)){
                    System.out.println("Ten thuoc moi khong hop le , vui long nhap lai : ");
                    tenthuocmoi=sc.nextLine();
                }

                System.out.println("Nhap gia moi :");
                double gia=sc.nextDouble();
                while(!isValidGiathuoc(gia)){
                    System.out.println("Gia moi khong hop le , vui long nhap lai : ");
                    gia=sc.nextDouble();
                }


                System.out.println("Nhap so luong moi :");
                int soluong=sc.nextInt();
                while(!isValidSoluong(soluong)){
                    System.out.println("So luong moi khong hop le , vui long nhap lai : ");
                    soluong=sc.nextInt();
                }

                for(int i=0;i<n;i++)
                {
                    if(dsthuoc[i].getTenthuoc().equals(Tenthuoc))
                    {
                        dsthuoc[i].setTenthuoc(tenthuocmoi);
                        dsthuoc[i].setSoluong(soluong);
                        dsthuoc[i].setGia(gia);
                    }

                }
            }


            //TIM
            @Override
            public void tim()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap ten thuoc can tim :");
                String Tenthuoc=sc.nextLine();
                for(int i=0;i<n;i++)
                {

                    if(dsthuoc[i].getTenthuoc().contains(Tenthuoc)){
                        dsthuoc[i].xuat();
                    }

                }
            }
            //nhap xuat du lieu tu file
            @Override
            public void DocFile(){

                
                
                try {
                     BufferedReader input = new BufferedReader(new FileReader("c:/VScode-Java/Java/doanoop/data/inputdanhsachthuoc.txt"));
                    
                    String line = input.readLine();
                    while (line != null) {
                        String[] arr = line.split(",");

                        // Kiểm tra

                        String type = arr[0]; //Kiểm tra loại thuốc

                        switch (type) {
                            case "tpchucnang":
                                if (arr.length == 5) {
                                    String tenthuoc = arr[1].trim();
                                    double gia = Double.parseDouble(arr[2].trim());
                                    int soluong = Integer.parseInt(arr[3].trim());
                                    String congdung = arr[4].trim();

                                    // Tạo đối tượng thucphamchucnang và thêm vào mảng ds
                                    tpchucnang tpcn = new tpchucnang( tenthuoc,  gia,  soluong, congdung);
                                    dsthuoc = Arrays.copyOf(dsthuoc, n + 1);
                                    dsthuoc[n] = tpcn;
                                    n++;
                                }
                                break;
                            case "thuocdactri":
                                if (arr.length == 5) {
                                    String tenthuoc = arr[1].trim();
                                    double gia = Double.parseDouble(arr[2].trim());
                                    int soluong = Integer.parseInt(arr[3].trim());
                                    String chucnang = arr[4].trim();

                                    // Tạo đối tượng thuocdactri và thêm vào mảng ds
                                    thuocdactri tdt = new thuocdactri( tenthuoc,  gia,  soluong,chucnang);
                                    dsthuoc = Arrays.copyOf(dsthuoc, n + 1);
                                    dsthuoc[n] = tdt;
                                    n++;
                                }
                                break;
                            default:
                                System.out.println("Unknown type: " + type);
                        }






                        //Xuat du lieu
                        // for (int i = 0; i<arr.length; i++){
                        //     System.out.println(arr[i]);
                        //
                        line = input.readLine();
                    }
                    input.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void GhiFile(){
              

                try (FileWriter fw = new FileWriter("c:/VScode-Java/Java/doanoop/data/outputdanhsachthuoc.txt")) {
                    for ( int i = 0 ; i<n ; i++ ){
                        if(dsthuoc[i] instanceof tpchucnang){
                            tpchucnang tpcn = (tpchucnang)dsthuoc[i];
                            fw.write("tpchucnang"+","+tpcn.getTenthuoc()+","+tpcn.getGia()+","+tpcn.getSoluong()+","+tpcn.getcongdung());
                        }
                        else if(dsthuoc[i] instanceof thuocdactri) {
                            thuocdactri tdt = (thuocdactri)dsthuoc[i];
                            fw.write("thuocdactri"+","+tdt.getTenthuoc()+","+tdt.getGia()+","+tdt.getSoluong()+","+tdt.getChucnang());
                        }
                        else{
                            System.out.println("error");
                        }

                        fw.write(System.lineSeparator());
                    }
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        class KHACHHANG extends nguoi {

            private String idkhachhang;

            public KHACHHANG()
            {
                super();
                idkhachhang="";
            }
            public KHACHHANG(String ten , String sodienthoai , String ngaysinh , String diachi,String idkhachhang)
            {
                super(ten, sodienthoai, ngaysinh, diachi);
                this.idkhachhang = idkhachhang;
            }



            public String getIdkhachhang()
            {
                return idkhachhang;
            }

            public void setIdkhachhang(String idkhachhang)
            {
                this.idkhachhang = idkhachhang;
            }




            @Override
            public void nhap()
            {

                Scanner sc = new Scanner(System.in);

                //Tenkhach
                System.out.println("Nhap ten khach: ");
                ten =sc.nextLine();
                while (!isValidTen(ten)){
                    System.out.println("Ten khach khong hop le , vui long nhap lai !");
                    System.out.println("Nhap ten khach: ");
                    ten = sc.nextLine();
                }



                //Diachi

                System.out.println("Nhap dia chi: ");
                diachi = sc.nextLine();



                //So dien thoai


                System.out.println("Nhap so dien thoai: ");
                sodienthoai=sc.nextLine();
                while (!isValidSoDienThoai(sodienthoai)){
                    System.out.println("So dien thoai khong hop le , vui long nhap lai !");
                    System.out.println("Nhap so dien thoai: ");
                    sodienthoai = sc.nextLine();
                }

                //Ngay sinh

                System.out.println("Nhap ngay sinh : ");
                ngaysinh = sc.nextLine();
                while(!isValidNgaySinh(ngaysinh))
                {
                    System.out.println("Ngay sinh khong hop le , vui long nhap lai !");
                    System.out.println("Nhap ngay sinh : ");
                    ngaysinh = sc.nextLine();

                }

                //Id khach hang

                System.out.println("Nhap id khach hang: ");
                idkhachhang = sc.nextLine();
                
                while(!isValidId(idkhachhang)){
                    System.out.println("Id khach hang khong hop le , vui long nhap lai !");
                    System.out.println("Nhap id khach hang: ");
                    idkhachhang = sc.nextLine();
                }





                System.out.println("----------------------------------------------------------------");

            }



            //KIEM TRA INPUT
            private boolean isValidTen(String ten) {
                return ten.matches("\\D+") && ten.length() <= 20;
            }

            private boolean isValidSoDienThoai(String sodienthoai) {
                return sodienthoai.matches("\\d{10}");
            }

            private boolean isValidId(String idkhachhang) {
                return idkhachhang.matches("\\d{10}");
            }

            private boolean isValidNgaySinh(String ngaySinh) {
                return ngaySinh.matches("\\d{2}/\\d{2}/\\d{4}");
            }
            //

            @Override
            public void xuat()
            {
                System.out.println("-----~~~~~~~~~~KHACHHANG~~~~~~~~~~-----");
                System.out.println("Ten khach: "+ten);
                System.out.println("Dia chi: "+diachi);
                System.out.println("Dien thoai: "+sodienthoai);
                System.out.println("Ngay sinh: "+ngaysinh);
                System.out.println("Id khach hang: "+idkhachhang);
            }

        }

        public class DSKHACHHANG implements QuanLy{
            KHACHHANG dskhachhang[];
            int n;
            public DSKHACHHANG(){
                n=0;
                dskhachhang=new KHACHHANG[0];
            }
            public DSKHACHHANG(int n, KHACHHANG ds[])
            {
                this.n=n;
                this.dskhachhang=Arrays.copyOf(ds,ds.length);
            }

            public boolean checkIdKhachHang(String idKhachHang)
            {
                for(int i=0;i<dskhachhang.length;i++)
                {
                    if(idKhachHang.equals(dskhachhang[i].getIdkhachhang()))
                    {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public void nhap()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap so luong khach hang : ");
                n=sc.nextInt();
                dskhachhang=new KHACHHANG[n];
                for(int i=0;i<n;i++)
                {
                    dskhachhang[i]=new KHACHHANG();
                    dskhachhang[i].nhap();
                }
            }

            @Override
            public void xuat()
            {
                System.out.println("--------------------------------------Danh sach khach hang-------------------------------");
                System.out.println("");
                System.out.printf("%-4s%-15s%-25s%-15s%-15s%-30s\n","STT","Ma khach hang","Ten khach hang","So dien thoai","Ngay sinh","Dia chi");
                for(int i=0;i<n;i++)
                {
                    System.out.printf("%-4d%-15s%-25s%-15s%-15s%-30s\n",i+1,dskhachhang[i].getIdkhachhang(),dskhachhang[i].getTen(),dskhachhang[i].getSodienthoai(),dskhachhang[i].getNgaysinh(),dskhachhang[i].getDiachi());
                }
            }

            //XOA
            @Override
            public void xoa()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap ten khach can xoa :");
                String Tenkhach=sc.nextLine();
                for(int i=0;i<n;i++)
                {
                    if(dskhachhang[i].getTen().equals(Tenkhach))
                    {
                        for(int j=i;j<n-1;j++)
                        {
                            dskhachhang[j]=dskhachhang[j+1];
                        }
                        n--;
                    }
                }
            }

            //THEM
            @Override
            public void them()
            {

                dskhachhang=Arrays.copyOf(this.dskhachhang,n+1);
                dskhachhang[n]=new KHACHHANG();
                System.out.println("-----~~~~~~~~~~THEMKHACHHANG~~~~~~~~~~-----");
                dskhachhang[n].nhap();
                n++;

            }

            //TIM
            @Override
            public void tim()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap ma khach hang can tim: ");
                String idKhachHang=sc.nextLine();
                boolean check=false;
                for(int i=0;i<n;i++)
                {
                    if(dskhachhang[i].getIdkhachhang().equals(idKhachHang))
                    {
                        dskhachhang[i].xuat();
                        check=true;
                    }
                }
                if(check==false)
                {
                    System.out.println("Khong tim thay khach hang can tim");
                }
            }

            //KIEM TRA INPUT
            private boolean isValidTen(String ten) {
                return ten.matches("\\D+") && ten.length() <= 20;
            }

            private boolean isValidSoDienThoai(String sodienthoai) {
                return sodienthoai.matches("\\d{10}");
            }

            private boolean isValidId(String idkhachhang) {
                return idkhachhang.matches("\\d{10}");
            }

        
            //

            //SUA
            @Override
            public void sua()
            {
                
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap ma khach hang can sua thong tin: ");
                String idKhachHang = sc.nextLine();
                while (!isValidId(idKhachHang)) {
                    System.out.println("Ma khach hang khong hop le , vui long nhap lai : ");
                    idKhachHang = sc.nextLine();
                }
                var checkID = false;

                for(int i=0;i<n;i++)
                {
                    if(dskhachhang[i].getIdkhachhang().equals(idKhachHang))
                            {
                                checkID = true;
                                break;
                            }           
                }
                

                while(checkID == false){
                    System.out.println("Khong ton tai khach hang nay !");
                    System.out.println("Nhap ma khach hang: ");
                    idKhachHang = sc.nextLine();
                    return;
                }


                System.out.println("Nhap ten khach hang moi: ");
                String tenkhachmoi=sc.nextLine();
                while (!isValidTen(tenkhachmoi)) {
                    System.out.println("Ten khach hang khong hop le , vui long nhap lai : ");
                    tenkhachmoi=sc.nextLine();
                }


                System.out.println("Nhap dia chi: ");
                String diachi = sc.nextLine();


                System.out.println("Nhap so dien thoai: ");
                String dienthoai = sc.nextLine();
                while (!isValidSoDienThoai(dienthoai)) {
                    System.out.println("So dien thoai khong hop le , vui long nhap lai : ");
                    dienthoai = sc.nextLine();
                }

                for(int i=0;i<n;i++)
                {
                    if(dskhachhang[i].getIdkhachhang().equals(idKhachHang))
                    {
                        dskhachhang[i].setTen(tenkhachmoi);
                        dskhachhang[i].setDiachi(diachi);
                        dskhachhang[i].setSodienthoai(dienthoai);
                        System.out.println("Sua thong tin thanh cong");
                        break;
                    }
                }
            }

            @Override
            //Luu va lay du lieu tu file
            public void DocFile(){

               
                
                try {
                   
                     BufferedReader input = new BufferedReader(new FileReader("c:/VScode-Java/Java/doanoop/data/inputkhachhang.txt"));
                    String line = input.readLine();
                    while (line != null) {
                        String[] arr = line.split(",");

                        // Kiểm tra xem có đủ thông tin để tạo đối tượng KhachHang không
                        if (arr.length == 5) {
                            String ten = arr[0].trim();
                            String diachi = arr[1].trim();
                            String sodienthoai = arr[2].trim();
                            String ngaysinh = arr[3].trim();
                            String idkhachhang = arr[4].trim();
                            // Tạo đối tượng KhachHang và thêm vào mảng ds
                            KHACHHANG khachhang = new KHACHHANG( ten , sodienthoai , ngaysinh , diachi, idkhachhang);
                            dskhachhang = Arrays.copyOf(dskhachhang, n + 1);
                            dskhachhang[n] = khachhang;
                            n++;
                        }

                        //Xuat du lieu
                        // for (int i = 0; i<arr.length; i++)
                        // System.out.println(arr[i]);

                        line = input.readLine();
                    }
                    input.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void GhiFile(){

                
                

                try (FileWriter fw = new FileWriter("c:/VScode-Java/Java/doanoop/data/outputkhachhang.txt")) {
                    for ( int i = 0 ; i<n ; i++ ){
                        KHACHHANG khachhang = dskhachhang[i];
                        fw.write(khachhang.getTen() +","+ khachhang.getDiachi() +","+ khachhang.getSodienthoai()+","+ khachhang.getNgaysinh()+","+khachhang.getIdkhachhang());
                        fw.write(System.lineSeparator());
                    }
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }


        }

}
