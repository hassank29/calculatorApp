package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var isNewOp=true
    var oldNumber=""
    var op="+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun tvNumberEvent(view: View){
        var express=findViewById<TextView>(R.id.tvExpression)
        if (isNewOp)
            express.setText("")
        isNewOp=false

   var buselect:TextView=view as TextView
        var buclickvalue:String=express.text.toString()
        var num1=findViewById<TextView>(R.id.tvone)
        var num2=findViewById<TextView>(R.id.tvtwo)
        var num3=findViewById<TextView>(R.id.tvthree)
        var num4=findViewById<TextView>(R.id.tvfour)
        var num5=findViewById<TextView>(R.id.tvfive)
        var num6=findViewById<TextView>(R.id.six)
        var num7=findViewById<TextView>(R.id.tvseven)
        var num8=findViewById<TextView>(R.id.tveight)
        var num9=findViewById<TextView>(R.id.nine)
        var num0=findViewById<TextView>(R.id.tvzero)
        var numdot=findViewById<TextView>(R.id.tvdot)
        var numplusminus=findViewById<TextView>(R.id.tvplusminus)

        when (buselect.id){
           num1.id->{
               buclickvalue+="1"
           }
            num2.id->{
                buclickvalue+="2"
            }
            num3.id->{
                buclickvalue+="3"
            }
            num4.id->{
                buclickvalue+="4"
            }
            num5.id->{
                buclickvalue+="5"
            }
            num6.id->{
                buclickvalue+="6"
            }
            num7.id->{
                buclickvalue+="7"
            }
            num8.id->{
                buclickvalue+="8"
            }
            num9.id->{
                buclickvalue+="9"
            }
            num0.id->{
                buclickvalue+="0"
            }
            numdot.id->{
                //TODO:Prevent more than 1 dot
                buclickvalue+="."
            }
            numplusminus.id->{
                buclickvalue= "-" +buclickvalue
            }
        }
        express.setText(buclickvalue)
    }

    fun operatorEvent(view: View) {
        var express=findViewById<TextView>(R.id.tvExpression)
        isNewOp=true
        oldNumber=express.text.toString()
        var plus=findViewById<TextView>(R.id.tvplus)
        var minus=findViewById<TextView>(R.id.tvminus)
        var mult=findViewById<TextView>(R.id.tvmult)
        var div=findViewById<TextView>(R.id.tvdiv)
        var buselect=view as TextView
        when(buselect.id){
            plus.id->{
                op="+"
            }
            minus.id->{
                op="-"
            }
            mult.id->{
                op="*"
            }
            div.id->{
                op="/"
            }
        }
    }

    fun equalEvent(view: View) {
        var express=findViewById<TextView>(R.id.tvExpression)
        var newnumber:String=express.text.toString()
        var result=0.0
        when(op){
           "+"->{result=oldNumber.toDouble()+newnumber.toDouble()}
            "*"->{result=oldNumber.toDouble()*newnumber.toDouble()}
            "-"->{result=oldNumber.toDouble()-newnumber.toDouble()}
            "/"->{result=oldNumber.toDouble()/newnumber.toDouble()}
        }
        express.setText(result.toString())
    }

    fun acEvent(view: View) {
        var express=findViewById<TextView>(R.id.tvExpression)
        express.setText("0")
        isNewOp=true
    }

    fun percentEvent(view: View) {
        var express=findViewById<TextView>(R.id.tvExpression)
        var no:Double=express.text.toString().toDouble()/100
        express.setText(no.toString())
        isNewOp=true
    }

    fun backEvent(view: View) {
        var express=findViewById<TextView>(R.id.tvExpression)
        var string=express.text.toString()
        if (string.isNotEmpty()){
            //delete one character
            express.text=string.substring(0,string.length-1)
        }
    }


}