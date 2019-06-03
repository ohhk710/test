## Java Script 

+ API: 내장함수, 내장객체,bom,dom

  

Type of data

+ number
+ boolean
+ string
+ undefined
+ object
+ function

+ parseInt : ->Integer..

브라우저 Gui 모드 제공

------

### <**script> ... </script**>

1. Output

```html
<script>
	document.write("도큐먼트영역에 출력하자");
	console.log("콘솔영역에 출력하자");
	window.alert("경고창에 출력하자");
</script>
```

2. Variable

   ```javascript
   var v1;
   document.write(v1+"<br>");
   ```

3. Type check

   ```javascript
   document.write("<h2>"+typeof undefined+ "</h2>")
   document.write("<h2>"+typeof '가'+ "</h2>")
   ->undefined
   ->string //char doesn't exist.
   ```

4. Operators

   + comparaison operators

     == : equalto / === equal value and equal type

     != : not equl /!=== not equl value or not equal type

     ? : =if / ! : logical not

   + Type Operators

     typeof : Returns the type of a variable

     instanceof : Returns true if an object is an instance of an object type

5. The prompt() method

   ```javascript
   var num = window.prompt("input a number");
   ```

6. Style- span

   ```javascript
   <style>
   span {
   	color: red
   }
   </style>
   
   <style> //with ID
   #blue {
   	color: blue;
   }
   
   #red {
   	color: red;
   }
   </style>
   
   <script>
       document.writeln("input a <span>number</span>");
   	document.writeln("<h2 id='red'>using id, color</h2>");
       </script>
   ```

7. The confirm() method

   ```javascript
   var result = window.confirm("continue? ");
   if (result == false)
   	break;
   ```

8. Array

   ```javascript
   var a1=[];
   var a2 = [ 10, '가나다', true, 3.5 ];
   var a1 = new Array(); //with new
   var a2 = new Array(10); ->10spaces
   
    Array.isArray(name) -> true/false for checking
    name.sort()->sort an Array
    
   !!Numeric sort
   	var ary3 = [ 30, 11, 5, 27, 9 ]
   	var ary4 = ary3.sort( function(a, b) {
   				return b - a;
   				} );
   	->ary4=[ 5, 9, 11, 27, 30 ]
   
   !toString(): Array->String
   
   !pushing items into an Array
   	var ary5 = [];
   		ary5.push(100);
   		ary5.push(200);
   		ary5.push(500);
   	->ary5=[100,200,500]
   ```

9. Button

   ```javascript
   <button onclick="clickProcess(100);">number</button>
   
   <script>
       function clickProcess(p) {
   		if (typeof p == "number") {
   			alert("숫자 전달!!");
   		}
       </script>
   ```

10. Function()

```javascript
		output("a");
		output( function(param) {
			console.log(param);
		} );
		function myAlert(param) {
			window.alert(param);
		} 
		/* var myAlert=function(param){
		 window.alert(param);
		 } */

		output(myAlert);// ->f.output(p)->p=f.maAlert
		
		function output(p) {
			if (typeof p == 'function') {
				p("lol lol");
			} else {
				document.write("<h2>lol : " + p + "</h2>");
			}
		}
```

11. try-catch

    ```javascript
    var g_v = 100;
    function scopeTest() {
    		var l_v = 1000;
    		document.write("scopeTest() l_v : " + l_v + "<br>");
    		document.write("scopeTest() g_v : " + g_v + "<br>");
    		}
    
    scopeTest();
    try {
    		document.write("l_v : " + l_v + "<br>");
    } catch (e) {
    		document.write(e + "<br>")
    }
    
    document.write("g_v : " + g_v + "<br>");
    
    =>ReferenceError: l_v is not defined
    ```

12. Creating a JavaScript Object
    + Using an Object Literal

```javascript
with ':' inside curly braces {}.
var person = {firstName:"John", 
              lastName:"Doe", 
              age:50, 
              eyeColor:"blue"};
create a function...
				getSum : function() {
					return this.kor+this.eng+this.math;
				}//this = owner of the function


with new
var person = new Object();
	person.firstName = "John";
	person.lastName = "Doe";
	person.age = 50;
	person.eyeColor = "blue";


adding a method to constructor
function Student(p1,p2,p3,p4){
			this.name = p1,
			this.kor = p2,
			this.eng = p3,
			this.math = p4,
			this.getSum = function() {
				return this.kor+this.eng+this.math;
			}
    
Using the prototype property
			Student.prototype.getSum = function() {
				return this.kor+this.eng+this.math;
				};
```

13. replace 'if'

    ```javascript
    var res = !rnum ? sum() : sum(rnum);
    	//= if not rnum, do sum(), ifnot : sum(rnum) 
    !res ? document.write("X") : document.write("value : " + res)	
    ```

14. Date ()

    ```javascript
    new Date() //today
    var d=new Date();
    
    7 numbers specify year, month, day, hour, minute, second, and millisecond (in that order):
    var d = new Date(2018, 11, 24, 10, 33, 30, 0);
    var d = new Date("October 13, 2014 11:13:00");
    
    getTime() = the number of milliseconds
    getMonth() =the month of a date as a number (0-11)//janvier=0
    getDate() = a date as a number (1-31)
    getDay() =the weekday of a date as a number (0-6)//sunday=0
    ```

15. Bom

    

