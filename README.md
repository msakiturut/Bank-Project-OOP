# Bank-Project-OOP
Java

Bu projede yeni kurulan bir banka için java uygulama gerçekleştirilmektedir. Bu bankada Kısa,
Uzun Vadeli ve Cari hesap diye 3 farklı türden hesap olmalıdır, ve her hesap türü aşağıda belirtilen
kendine ait özelliklere sahip olmalıdır. 

 Account sınıfı abstract olarak tanımlanmalıdır.
- Bu sınıftan üretilen her nesne bir banka hesabıdır.
- Bu sınıf şu fonksiyonlara sahip olmalıdır:
• deposit : hesaba para yatırılmasına yarar.
• withdraw : hesaptan para çekilmesine yarar.
Bu işlem yapılırken hesap türüne ve mevcut bakiyeye dikkat edilmelidir.
(Çekilebilecek miktar belirtilmeli, mevcut bakiyeden fazla çekilmeye çalışılırsa hata vermeli gibi
özellikler düşünülmelidir.)
• getBalance : hesabın anlık bakiyesini görüntülemeye yarar.
• getID : hesap numarasını görüntülemeye yarar. (hesap numarası sabit tam sayıdır).
• Benefit(kâr) : hesap açma günü ve işlem tarihine göre kar miktarı hesaplar.
(yıllık kar r olursa günlük kar r/365 hesaplanır).
programda 4 tür hesap için şu kurallar tanımlamalı:
1. ShortTerm: bu tür hesap yıllık %17 faiz verir ve en az 1000 TL hesapta bakiye olması gerekiyor.
2. LongTerm: bu tür hesap yıllık %24 faiz verir ve en az 1500 TL hesapta bakiye olmasi gerekiyor.
3. Current: bu hesap faizsizdir ve hesapta para olma zorunluluğu yoktur.

Tüm sistemi kontrol etmesi için başka bir sınıf (Bank) tanımlanmalıdır.
Bu sınıfta Account türünden bir değişken olmalı. (Account accounts). Bu değişken tüm hesapları tutar.
Bu sınıf şu fonksiyonlara sahip olmalıdır:

• getAccount : mevcut hesapların listesini görüntülemeye yarar.

• getDate: sistemin şu anki tarihini görüntülemeye yarar.

• deposit(ID, cash): ID’si belirtilen hesaba, belirtilen miktarda para yatırma işlemi yapmaya yarar.

• Withdraw(ID, cash): eğer mümkün ise, belirtilen miktarda hesaptan para çekme işlemi yapar.
(transaction işleminin başarılı ya da başarısız olması gibi durumlar kullanıcıya bildirilir.)

Program kullanıcıya konsoldan aşağıdaki işlemleri yapabilmesini sağlamalıdır:
1. Create_S_ID_balance: Kısa vadeli hesap açar. (hesap no=ID, başlangıç parası = balance)
2. Create_L_ID_balance: Uzun vadeli hesap açar. (hesap no=ID, başlangıç parası = balance)
3. Create_C_ID_balance: Cari hesap açar. (hesap no=ID, başlangıç parası = balance)
4. Increase_ID_cash: ID’ye ait hesaba “cash” kadar para ekler.
5. Decrease_ID_cash: ID’ye ait hesaptan “cash” kadar para çeker.
6. Show Accounts Id And Last 5 Transactions :Hesap numarası ve yaptığı son 5 işlemi gösterir.
7. Show Accounts information: Tüm hesapların hesap numarasını, türünü, bakiyesini ve açılış tarihini gösterir .
8. ShowIDs: Sistemdeki tüm hesap numaralarını listeler.


