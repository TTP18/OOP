
package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.* ;

import classes.*;


public class hoadon {
    
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

            class CHITIETHOADON
        {
            protected long gia;
            protected String tenthuoc;
            protected int soluong;
            public CHITIETHOADON()
            {
                gia=soluong=0;
                tenthuoc="";
            }
            public CHITIETHOADON(long gia,String tenthuoc,int soluong)
            {
                this.gia=gia;
                this.tenthuoc=tenthuoc;
                this.soluong=soluong;
            }
            private boolean isValidSoluong(int soluong) {
                return soluong>0&&soluong<20;
            }
            private boolean isValidGiathuocc(long gia)
            {
                return gia>1000&&gia<1000000;
            }
            private boolean checkTenThuoc(String tenThuoc)
            {
                thuocvakhachhang a = new thuocvakhachhang();
                thuocvakhachhang.DSTHUOC ds1 = a.new DSTHUOC();
                // DSTHUOC ds1 =new DSTHUOC();
                ds1.DocFile();
                if(ds1.checkTenThuoc(tenThuoc)==false)
                    return false;
                else
                    return true;
            }

            //@Override
            public void nhap()
            {
                Scanner sc = new Scanner( System.in );

                System.out.println(" Nhap ten thuoc :") ;
                tenthuoc = sc.nextLine() ;
                while(checkTenThuoc(tenthuoc)!=true)
                {
                    System.out.println("(!) Ten thuoc khong ton tai trong danh sach");
                    System.out.println("Vui long nhap lai:");
                    tenthuoc=sc.nextLine();
                }

                System.out.println(" Nhap gia thuoc :") ;
                gia = sc.nextLong() ;
                while (!isValidGiathuocc(gia))
                {
                    System.out.println("(!) Gia thuoc chua hop le vui long nhap lai");
                    System.out.println("Nhap lai gia thuoc:");
                }
                System.out.println(" Nhap so luong thuoc :") ;
                soluong = sc.nextInt() ;
                while (!isValidSoluong(soluong))
                {
                    System.out.println("(!) So luong chua hop le vui long nhap lai");
                    System.out.println("Nhap lai so luong:");
                }
            }
            //@Override
            public void xuat()
            {
                System.out.println(" Ten thuoc : " + tenthuoc ) ;
                System.out.println(" Gia thuoc : " + gia ) ;
                System.out.println(" So luong thuoc : " + soluong ) ;

            }

        }

        //========================================================HOA==DON===============================================================================
        class HOADON
        {
            private String thoiGian;
            private String maHoaDon ;
            private String maNhanVien;
            private String maKhachHang ;
            private long tongHoaDon;
            CHITIETHOADON chiTietHoaDon[];
            private int n;
            public HOADON ()
            {
                maHoaDon = maKhachHang = "" ;
                thoiGian=maNhanVien="";
                n=0;
                chiTietHoaDon=new CHITIETHOADON[0];
            }

            public HOADON(String maHoaDon, String thoiGian, String maKhachHang  ,String maNhanVien,int n,CHITIETHOADON[]chiTietHoaDon)
            {
                this.maHoaDon = maHoaDon  ;
                this.thoiGian=thoiGian;
                this.maNhanVien=maNhanVien;
                this.maKhachHang  = maKhachHang  ;
                this.n=n;
                this.chiTietHoaDon=Arrays.copyOf(chiTietHoaDon,chiTietHoaDon.length);
            }
            public HOADON(String maHoaDon, String thoiGian, String maKhachHang  ,String maNhanVien)
            {
                this.maHoaDon = maHoaDon  ;
                this.thoiGian=thoiGian;
                this.maNhanVien=maNhanVien;
                this.maKhachHang  = maKhachHang  ;
            }
            public void setManhanvien ( String maNhanVien ){
                this.maNhanVien = maNhanVien ;
            }
            public String getManhanvien (){
                return this.maNhanVien ;
            }
            public void setMahoadon ( String maHoaDon ){
                this.maHoaDon = maHoaDon ;
            }
            public String getMahoadon (){
                return this.maHoaDon ;
            }

            public void setThoiGian ( String thoiGian ){
                this.thoiGian = thoiGian ;
            }
            public String getThoiGian (){
                return this.thoiGian;
            }
            public void setmaKhachHang ( String maKhachHang ){
                this.maKhachHang = maKhachHang ;
            }
            public String getmaKhachHang (){
                return this.maKhachHang ;
            }
            public void setChiTietHoaDon(int n,CHITIETHOADON[]chiTietHoaDon)
            {
                this.n=n;
                this.chiTietHoaDon=Arrays.copyOf(chiTietHoaDon,chiTietHoaDon.length);
            }
            public long getTongHoaDon()
            {
                for(int i=0;i<n;i++)
                {
                    tongHoaDon+=chiTietHoaDon[i].gia*chiTietHoaDon[i].soluong;
                }
                return this.tongHoaDon;
            }
            public int getN()
            {
                return this.n;
            }
            //Ham kiem tra dau vao
            private boolean isvalidTime(String s)
            {
                SimpleDateFormat fday=new SimpleDateFormat("dd");
                SimpleDateFormat fmonth=new SimpleDateFormat("MM");
                SimpleDateFormat fyear=new SimpleDateFormat("yyyy");
                Date nowdate=new Date();
                String []date=s.split("-");
                int ngayktr=Integer.parseInt(date[0]);
                int thangktr=Integer.parseInt(date[1]);
                int namktr=Integer.parseInt(date[2]);
                int daynow=Integer.parseInt(fday.format(nowdate));
                int monthnow=Integer.parseInt(fmonth.format(nowdate));
                int yearnow=Integer.parseInt(fyear.format(nowdate));
                if(ngayktr<1||ngayktr>31)
                {
                    return false;
                }
                if(thangktr<1||thangktr>12)
                {
                    return false;
                }
                if(namktr<yearnow)
                {
                    return true;
                }
                else if(namktr==yearnow)
                {
                    if(thangktr<monthnow)
                    {
                        return true;
                    }
                    else if(thangktr==monthnow)
                    {
                        if(ngayktr>daynow||ngayktr>getDaysInMonth(thangktr, namktr))
                        {
                            return false;
                        }
                        else
                        {
                            return true;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            // Kiem tra dinh dang thoi gian
            private boolean isvalidStringTime(String thoiGian)
            {
                return thoiGian.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}");
            }
            private int getDaysInMonth(int month, int year) {
                

                int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                if (month == 2 && isLeapYear(year)) {
                    return 29;
                }
                return daysInMonth[month - 1];
            }
            private boolean checkID(String ma)
            {
                ma=ma.trim();
                return ma.length()>2;
            }
            private boolean isLeapYear(int year) {
                // Kiểm tra năm nhuận
                return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            }
            private boolean isvalidmnv(String maNhanVien)
            {
                nhanvien a = new nhanvien();
                nhanvien.DSNhanVien dsnvien = a.new DSNhanVien();
                // DSNhanVien dsnvien=new DSNhanVien();
                dsnvien.DocFile();
                if(dsnvien.checkIdNhanVien(maNhanVien)==false||checkID(maNhanVien)==false)
                    return false;
                else
                    return true;
            }
            private boolean isvalidmkh(String maKhachHang)
            {
                thuocvakhachhang a = new thuocvakhachhang();
                thuocvakhachhang.DSKHACHHANG ds2 = a.new DSKHACHHANG();
                // DSKHACHHANG ds2=new DSKHACHHANG();
                ds2.GhiFile();
                if(ds2.checkIdKhachHang(maKhachHang)==false||checkID(maKhachHang)==false)
                    return   false;
                else
                    return true;

            }
            private boolean isvalidslt(int soloaithuoc)
            {
                return soloaithuoc>=1&&soloaithuoc<=20;
            }
            private boolean idvalidMHD(String maHoaDon)
            {
                DANHSACHHOADON dshd=new DANHSACHHOADON();
                dshd.DocFile();
                if(dshd.checkMaHoaDon(maHoaDon)==false)
                    return false;
                else
                    return true;
            }

            //Nhap xuat du lieu
            public void nhap()
            {
                Scanner sc = new Scanner( System.in );
                System.out.println("======================================NHAP-HOA-DON==================================");
                System.out.println("Nhap vao thoi gian theo dang dd-MM-yyyy:");
                thoiGian=sc.nextLine();
                while(!isvalidStringTime(thoiGian))
                {
                    System.out.println("(!) Nhap sai dinh dang thoi gian. Hay nhap lai");
                    thoiGian=sc.nextLine();
                }
                if(isvalidStringTime(thoiGian))
                {
                    while (!isvalidTime(thoiGian)) {
                        System.out.println("(!) Nhap sai thoi gian. Hay nhap lai");
                        thoiGian=sc.nextLine();
                    }
                }
                System.out.println("Nhap ma hoa don :");
                maHoaDon = sc.nextLine() ;
                while (idvalidMHD(maHoaDon)!=true) {
                    System.out.println("(!) Ma hoa don nhap bi trung. Vui long nhap lai ma hoa don");
                    maHoaDon=sc.nextLine();
                }

                System.out.println("Nhap ma khach hang :");
                maKhachHang=sc.nextLine();
                while (isvalidmkh(maKhachHang)!=true)
                {
                    System.out.println("(!) Ma khach hang khong ton tai trong danh sach. Vui long nhap lai");
                    maKhachHang=sc.nextLine();
                }

                System.out.println("Nhap ma nhan vien :");
                maNhanVien=sc.nextLine();

                while (isvalidmnv(maNhanVien)!=true)
                {
                    System.out.println("(!) Ma nhan vien khong ton tai trong danh sach. Vui long nhap lai");
                    maNhanVien=sc.nextLine();
                }

                System.out.println("Nhap vao so loai thuoc :");
                n=sc.nextInt();
                while(!isvalidslt(n))
                {
                    System.out.println("(!) So luong thuoc nhap chua dung. Moi nhap lai:");
                    n=sc.nextInt();
                }

                chiTietHoaDon=new CHITIETHOADON[n];
                System.out.println("Nhap chi tiet hoa don :");
                for(int i=0;i<n;i++)
                {
                    chiTietHoaDon[i]=new CHITIETHOADON();
                    chiTietHoaDon[i].nhap();
                }
            }

            public void xuat() {
                System.out.println("========================================HOA-DON=================================================");
                System.out.println("");
                System.out.print("Ma khach hang : " + maKhachHang ) ;
                System.out.println("                    Ma hoa don : " + maHoaDon) ;
                System.out.println("Ma nhan vien ban thuoc : " + maNhanVien ) ;
                System.out.println("");
                System.out.println("Danh Sach Thuoc: ");
                System.out.println("");
                System.out.printf("%-15s%-10s%-20s%s\n","Ten Thuoc","So luong","Don gia","Tong Gia");
                for(int i=0;i<n;i++)
                {
                    System.out.printf("%-15s%-10d%-20d%d\n",chiTietHoaDon[i].tenthuoc,chiTietHoaDon[i].soluong,chiTietHoaDon[i].gia,chiTietHoaDon[i].soluong*chiTietHoaDon[i].gia);
                }
                System.out.println("");
                System.out.println("                                Tong hoa don : " + getTongHoaDon()) ;
                System.out.println("");
                System.out.println("                                                 Thoi gian hoa don : "+ thoiGian ) ;
            }

        }


        //============================================================DSHOADON============================================================================



        public class DANHSACHHOADON implements QuanLy
        {
            HOADON[] dshd;
            private int n;
            private String maHoaDonCanXoa;
            private String maHoaDonCanTim;
            private String maHoaDonCanSua;
            public DANHSACHHOADON()
            {
                n=0;
                dshd=new HOADON[0];
            }
            public DANHSACHHOADON(int n,HOADON ds[])
            {
                this.n=n;
                this.dshd=Arrays.copyOf(ds,ds.length);
            }

            public boolean checkMaHoaDon(String maHoaDon)
            {
                for(int i=0;i<dshd.length;i++)
                {
                    if(dshd[i].getMahoadon().equals(maHoaDon))
                    {
                        return false;
                    }
                }
                return true;
            }
            @Override
            public void nhap()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap so luong hoa don!");
                n=sc.nextInt();
                dshd=new HOADON[n];
                for(int i=0;i<n;i++)
                {
                    dshd[i]=new HOADON();
                    dshd[i].nhap();
                }
            }
            @Override
            public void xuat()
            {
                System.out.println("Xuat danh sach hoa don !");
                for(int i=0;i<n;i++)
                {
                    dshd[i].xuat();
                }
            }
            @Override
            public void them()
            {
                HOADON hoaDonMoi=new HOADON();
                dshd=Arrays.copyOf(dshd, n+1);
                dshd[n]=hoaDonMoi;
                System.out.println("Them Hoa Don !");
                dshd[n].nhap();
                n++;
            }
            @Override
            public void xoa()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap ma hoa don can xoa!");
                maHoaDonCanXoa=sc.nextLine();
                boolean check=false;
                for(int i=0;i<n;i++)
                {
                    if(dshd[i].getMahoadon().equals(maHoaDonCanXoa))
                    {
                        for(int j=i;j<n-1;j++)
                        {
                            dshd[j]=dshd[j+1];
                        }
                        check=true;
                        dshd=Arrays.copyOf(dshd, n-1);
                        n--;
                        break;
                    }
                }
                if(check==false)
                {
                    System.out.println("Khong tim thay hoa don can xoa");
                }
            }
            @Override
            public void sua()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap ma hoa don can sua !");
                maHoaDonCanSua=sc.nextLine();
                boolean check=false;
                for(int i=0;i<n;i++)
                {
                    if(dshd[i].getMahoadon().equals(maHoaDonCanSua))
                    {
                        //System.out.println("============SUA-HOA-DON=============");
                        dshd[i].nhap();
                        check=true;
                        break;
                    }
                }
                if(check=false)
                {
                    System.out.println("Khong tim thay hoa don can sua");
                }

            }
            @Override
            public void tim()
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Nhap ma doa don can tim!");
                maHoaDonCanTim=sc.nextLine();
                boolean check=false;
                for(int i=0;i<n;i++)
                {
                    if(dshd[i].getMahoadon().equals(maHoaDonCanTim))
                    {
                        dshd[i].xuat();
                        check=true;
                        break;
                    }
                }
                if(check=false)
                {
                    System.out.println("Khong tim thay hoa don!");
                }

            }
            @Override
            public void DocFile()
            {
                
                
                try {
                    
                     BufferedReader input = new BufferedReader(new FileReader("c:/VScode-Java/Java/doanoop/data/inputdshd.txt"));
                    String line = input.readLine();

                    while (line != null) {
                        String[] arr = line.split(",");

                        // Kiểm tra xem có đủ thông tin để tạo đối tượng Hoadon không
                        if (arr.length >= 8)
                        {
                            String maHoaDon = arr[0].trim();
                            String maNhanVien = arr[1].trim();
                            String thoiGian = arr[2].trim();
                            String maKhachHang = arr[3].trim();
                            int soLuongThuoc = Integer.parseInt(arr[4].trim());
                            int countarr=5;
                            int countcthd=0;
                            CHITIETHOADON cthd[];
                            cthd=new CHITIETHOADON[soLuongThuoc];
                            // cthd[0]=new CHITIETHOADON();
                            while(countarr!=arr.length)
                            {
                                cthd[countcthd]=new CHITIETHOADON();
                                cthd[countcthd].tenthuoc=arr[countarr].trim();
                                countarr++;
                                cthd[countcthd].gia=Integer.parseInt(arr[countarr].trim());
                                countarr++;
                                cthd[countcthd].soluong=Integer.parseInt(arr[countarr].trim());
                                countarr++;
                                countcthd++;
                            }
                            // Tạo đối tượng Hoadon và thêm vào mảng dshd
                            HOADON hd= new HOADON(maHoaDon,thoiGian,maKhachHang,maNhanVien,soLuongThuoc,cthd);
                            dshd = Arrays.copyOf(dshd, n + 1);
                            dshd[n] = hd;
                            n++;
                        }

                        line = input.readLine();
                    }

                    input.close();
                    System.out.println("Doc file vao mang danh sach hoa don thanh cong !");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            @Override
            public void GhiFile(){
                

                try (FileWriter fw = new FileWriter("c:/VScode-Java/Java/doanoop/data/outputdshd.txt")) {
                    for ( int i = 0 ; i<n ; i++ )
                    {
                        HOADON hd = dshd[i];
                        fw.write(hd.getMahoadon() + "," + hd.getManhanvien() + "," + hd.getThoiGian() + "," +
                                hd.getmaKhachHang() + "," + hd.getN());
                        for(int j=0;j<hd.getN();j++)
                        {
                            fw.write("," + hd.chiTietHoaDon[j].tenthuoc + "," + hd.chiTietHoaDon[j].gia + "," + hd.chiTietHoaDon[j].soluong);
                        }
                        fw.write(System.lineSeparator());
                    }
                    System.out.println("Ghi file vao danh sach thanh cong!");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }



        }
}
