package com.example.shoper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.shoper.databinding.ActivityMainBinding
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{// создаем и имплементируем методы для адаптера
    lateinit var binding: ActivityMainBinding
   var price:Double? =null// создаем переменную для цены товара
   var count=0// создаем переменную для счетчика товара
    var Name:String?=null// создаем пустую переменную для наименований
    var UserName:EditText?=null//создаем пустую переменную едит текст
private var spinner:Spinner?=null// создаем пустую переменную спиннер
    var hashMap : HashMap<String, Double> = HashMap()//создаем переменную хашмап

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      spinner=binding.spinner// связываем переменную спиннер с ксмл
        UserName=binding.ED// связываем  переменную для эдит текст с ксмл



        val Array= mutableListOf("Фендер","Кремона","Гибсон")//создаем список для листа
       val adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item,Array)//создаем адаптер для спиннера
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.adapter=adapter// вкладываем значения в спиннер
        spinner?.onItemSelectedListener = this// создаем слушатель для адаптер
        hashMap.put("Фендер",2500.0)// создаем хашмап где ключ это наименование адаптера
        hashMap.put("Кремона",250.0)
        hashMap.put("Гибсон",25000.0)


        binding.plus.setOnClickListener {// создаем счетчик для подсчета количества
            count++
            binding.colichestvo.text=count.toString()
            binding.summa.setText(summa())// считаем сумму товаров со счетчиком
        }
 binding.minus.setOnClickListener {
     if (count!=0)
     count--
     binding.colichestvo.text=count.toString()
     binding.summa.setText(summa())



     }
 }



    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
  Name = spinner!!.selectedItem.toString()// в имплементированном методе мы создаем переменню куда вкладываем данные спиннера

    price = hashMap.get(Name)// создаем переменную где обьявляем цену товара по ключу наименования переменной
        binding.summa.text= summa()

     var Image=binding.Guitar// создаем переменную для смены картинок
        if(Name.equals("Фендер"))// приравниваем ссылку для спинера к ссылке в для неаименования товара
            Image.setImageResource(R.drawable.guitar_free)// меняем картинку
        if(Name.equals("Кремона"))
            Image.setImageResource(R.drawable.guitar_one)
        if(Name.equals("Гибсон"))
            Image.setImageResource(R.drawable.guitar_two)

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {


}
    fun summa():String{// метод для подсчета товаров возвращаем значение арифметической операции
        var a:Double
        var b:Double
        binding.apply {
            a=count.toString().toDouble()
            b=price.toString().toDouble()
        }
return (a*b).toString()
    }

    fun Corxina(view: View) {// создаем на кнопке функцию для передачи на другую активити(корзину)
        val Simpl1=Simpl()
        Simpl1.Ymya=UserName?.getText().toString()
        Log.d("Naaaa", Simpl1.Ymya!!)
        Simpl1.Naimenivania=Name.toString()
        Log.d("Naaaa", Simpl1.Naimenivania!!)
        Simpl1.Price=price!!.toDouble()
        Log.d("Naaaa", Simpl1.Price.toString())
        Simpl1.Summa=summa().toDouble()
        Log.d("Naaaa", Simpl1.Summa.toString())
        Simpl1.Count=count
        Log.d("Naaaa", Simpl1.Count.toString())
        val intent=Intent(this,MainActivity2::class.java)
        intent.putExtra("Имя",Simpl1.Ymya)
        intent.putExtra("Наименование",Simpl1.Naimenivania)
        intent.putExtra("Прайс",Simpl1.Price)
        intent.putExtra("Summa", Simpl1.Summa)
        intent.putExtra("Count",Simpl1.Count)
        startActivity(intent)
    }

}

private operator fun Double.times(let: Double.Companion?): Any {
return Double
}










