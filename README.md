##           Başlangıç işlemleri


Android uygulamalarda başlangıçta async olarak yapılan işlemler; sayısı arttıkça uygulamanın 
başlangıcında yığılarak daha fazla zaman almaya başlar. Hatta buna bağlı olarak oluşmamış objenin
erişimine yeltenileceğinden dolayı nullpointerlar ile karşılaşabilirsiniz.

Şuana kadar uygulamanın başlangıcında çok fazla thread oluşturup işlem yapıyorsanız ve bu işlemlerin
doğru bir şekilde işlediğini düşünüyorsanız hata yapıyor _olabilirsiniz._ Cihazların durumu, 
donanımı, kullanım şekli, hafızadaki işlemler gibi birçok değişken bunu etkileyebileceği için bu 
işleri olabildiğince sıralı yapmak gerekir. Bu kod da verilen async işlemleri sync şekilde 
çalıştırır.

Geliştirmeye tamamen açık olan bu projede önemli olan farklı asyncTask class'larını doğru şekilde 
bir listede tutmak ve bu listeden işlemek.

Şuanda ArrayList<Object> şeklinde bir yapı kullandım. Temelde aldığım bu objeleri cast ederek iş 
classlarına ulaşıyorum, başlatıyorum, bekletiyorum.



#### ROADMAP

 - Object içeren listeden kurtularak cast işlemlerini azaltabiliriz.
 - Error handling işlemleri eklenmeli.
    - Belirli hatalarda, belirli işlemler yaparak devam etme. 
 - Önceliği yüksek işler için (Lisanslama  vb.) yapılmazsa devam edilemesin gibi senaryolar.
 - Verilen x adet işin belirli işleri(örneğin a ve b sırasındaki işler) kendisinden sonraki iş ile birlikte 
 çalışsın gibi senaryolar eklenebilir.


## v1.0.1 || March 11,2019
```
	Retrofit argesi eklendi.
	XX.class.isInstance daha maliyetsizmiş. instanceof yerine kullanıldı.

```