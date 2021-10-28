function functia1(){
    

            var nr1 = document.getElementById("nrpr1").value;
            var rezInput = document.getElementById("rez");
            var numbers = /^[\d +-]+$/;

            if (nr1.match(numbers)){
                nrRez= parseInt(nr1) + 1;
                rezInput.value = nrRez;
                var veziRez=document.getElementById("rezultat");
                veziRez.style.display="block";

            } else {
                alert("Trebuie sa introduci un numar intreg!");
                // document.getElementById("nrpr1").value = "";
                var veziRez=document.getElementById("rezultat");
                veziRez.style.display="none";
            }
}

function functia2(){
            var nr1 = document.getElementById("nrpr2").value;
            var rezInput = document.getElementById("rez");
            var numbers = /^[\d +-]+$/;

            if (nr1.match(numbers)){
                nrRez= - parseInt(nr1);
                rezInput.value = nrRez;
                var veziRez=document.getElementById("rezultat");
                veziRez.style.display="block";

            } else {
                alert("Trebuie sa introduci un numar intreg!");
                // document.getElementById("nrpr2").value = "";
                var veziRez=document.getElementById("rezultat");
                veziRez.style.display="none";
            }
}

function functia3(){
            var nr1 = document.getElementById("nrpr3").value;
            var rezInput = document.getElementById("rez");
            var numbers = /^[\d +-]+$/;

            if (nr1.match(numbers)){
                nrRez= parseInt(nr1);
                if (nrRez == 0) {
                    rezInput.value = "S-a introdus o valoare nula";
                } else { if (nrRez < 0){
                    rezInput.value = "S-a introdus o valoare negativa";
                } else {
                    rezInput.value = "S-a introdus o valoare pozitiva";
                }
                }
                var veziRez=document.getElementById("rezultat");
                veziRez.style.display="block";

            } else {
                alert("Trebuie sa introduci un numar intreg!");
                // document.getElementById("nrpr3").value = "";
                var veziRez=document.getElementById("rezultat");
                veziRez.style.display="none";
            }
}

function functia4(){
            var nr1 = document.getElementById("nrpr4").value;
            var nr2 = document.getElementById("nrpr4_1").value;
            var rezInput = document.getElementById("rez");
            var numbers = /^[\d .,+-]+$/;

            var found = check2(nr1, nr2, "nrpr4", "nrpr4_1");
       

            if (nr1.match(numbers) && nr2.match(numbers) && found == false){
                var a = parseFloat(nr1);
                nr1 = parseFloat(nr2);
                nr2 = a;
                rezInput.value = "Primul numar a devenit: " + nr1 + "\n" +  "Al doilea numar a devenit: " + nr2;
                
                var veziRez=document.getElementById("rezultat");
                veziRez.style.display="block";
            } 
}
 

function functia5(){
            var nr1 = document.getElementById("nrpr5").value;
            var nr2 = document.getElementById("nrpr5_1").value;
            var rezInput = document.getElementById("rez");
            var numbers = /^[\d .+-]+$/;

            var found = check2(nr1, nr2, "nrpr5", "nrpr5_1");

            if (nr1.match(numbers) && nr2.match(numbers) && found == false){
                var suma = parseFloat(nr1) + parseFloat(nr2);
                var produs = parseFloat(nr1) * parseFloat(nr2);
              
                rezInput.value = "Suma numerelor este: " + suma + "\n" + "Produsul elementelor este: " + produs.toFixed(2);
                
                var veziRez=document.getElementById("rezultat");
                veziRez.style.display="block";
            } 
}

function functia6(){
    var nr1 = document.getElementById("nrpr6").value;
    var nr2 = document.getElementById("nrpr6_1").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d .+-]+$/;
    
    var found = check2(nr1, nr2, "nrpr6", "nrpr6_1");

    if (nr1.match(numbers) && nr2.match(numbers) && found == false){
        var newnr1 = parseFloat (nr1);
        var newnr2 = parseFloat (nr2);

        if (newnr1 == newnr2 ){
            rezInput.value = "Cele doua numere sunt egale :) ";
        } else {if  (newnr1 > newnr2) {
            rezInput.value = "Valoarea maxim este: " + newnr1.toFixed(2) + "\n" + "Valoarea minima este: " + newnr2.toFixed(2);
        } else {
            rezInput.value = "Valoarea maxim este: " + newnr2.toFixed(2) + "\n" + "Valoarea minima este: " + newnr1.toFixed(2);
        }
          }
        
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
    } 
}

function functia7(){
    var nr1 = document.getElementById("nrpr7").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d .,+-]+$/;

    if (nr1.includes(".")) {
        var dotCount1= nr1.match((/\./g)|| []).length;
    } else {
        dotCount1 = 0;
    }

    if (nr1.includes(",")) {
        var commaCount1= nr1.match((/\,/g)|| []).length;
    } else {
        commaCount1 = 0;
    }

    if (commaCount1 == 1 ) {
        alert("Foloseste . in loc de , !");
        document.getElementById("nrpr3").value = "";
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
        return;
    }

    if (nr1.match(numbers) && (commaCount1 == 0) && (dotCount1 <= 1)){
        var nrRez= parseFloat(nr1);
        if (nrRez < 0) {
            rezInput.value = "Distanta invalida";
        } else { 
            var rezkm = nrRez * 1.60934;
            rezInput.value = nrRez.toFixed(2) + " mile = " + rezkm.toFixed(4) + " km";
        }
        
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";

    } else {
        alert("Trebuie sa introduci un numar intreg!");
        // document.getElementById("nrpr7").value = "";
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    }
}


function functia8(){
    var nr1 = document.getElementById("nrpr8").value;
    var nr2 = document.getElementById("nrpr8_1").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d .+-]+$/;
    
    var found = check2(nr1, nr2, "nrpr8", "nrpr8_1");

    if (nr1.match(numbers) && nr2.match(numbers) && found == false){
        var newnr1 = parseFloat (nr1);
        var newnr2 = parseFloat (nr2);
        

        if (newnr2 == 0 ){
            rezInput.value = "Operatie imposibila, numitorul este nul!";
        } else {
            var fractie = Math.round(newnr1 / newnr2 * 1000) / 1000;

            rezInput.value = "Valoarea fractiei este: " + fractie;
        
        }
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";       
    } 
}

function functia9(){
    var nr1 = document.getElementById("nrpr9").value;
    var nr2 = document.getElementById("nrpr9_1").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d .+-]+$/;
    
    var found = check2(nr1, nr2, "nrpr9", "nrpr9_1");

    if (nr1.match(numbers) && nr2.match(numbers) && found == false){
        var newnr1 = parseFloat (nr1);
        var newnr2 = parseFloat (nr2);

        if (newnr2 == 0 ){
            rezInput.value = "Operatie imposibila, viteza nu poate fi nula!";
        } else { if ((newnr1 <= 0) || (newnr2 <= 0)) {
            rezInput.value = "Ambele valori trebuie sa fie pozitive!";
        } else {
            var fractie = Math.round(newnr1 / newnr2 * 100) / 100;

            rezInput.value = "Viteza media de deplasare este: " + fractie;
        }  
       }
       var veziRez=document.getElementById("rezultat");
       veziRez.style.display="block";
    } 
}

function functia10(){
    var nr1 = document.getElementById("nrpr10").value;
    var nr2 = document.getElementById("nrpr10_1").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d .+-]+$/;
    
    var found = check2(nr1, nr2, "nrpr10", "nrpr10_1");

    if (nr1.match(numbers) && nr2.match(numbers) && found == false){
        var newnr1 = parseFloat (nr1);
        var newnr2 = parseFloat (nr2);

        if (newnr1 == 0 ) { 
            if (newnr2 == 0) {
                rezInput.value = "Ecuatia este: " + newnr1 + "*X " + " + " + newnr2  + " = 0." + "\n" + "Solutia este: multimea numerelor Reale.";
              
            } else {
                rezInput.value = "Ecuatia este: " + newnr1 + "*X " + " + " + newnr2 + " = 0." + "\n" + "Solutia este: ecuatia nu are solutie.";
            }
        } else {
            var fractie = Math.round(- newnr2 / newnr1 * 100) / 100;
            rezInput.value = "Ecuatia este: " + newnr1 + "*X " + " + " + newnr2 + " = 0." + "\n" + "Solutia este: X = " + fractie;
       }
       var veziRez=document.getElementById("rezultat");
       veziRez.style.display="block";
    } 
}

function functia11(){
    var nr1 = document.getElementById("nrpr11").value;
    var nr2 = document.getElementById("nrpr11_1").value;
    var nr3 = document.getElementById("nrpr11_2").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d .+-]+$/;
    
    var found = check3(nr1, nr2, nr3, "nrpr11", "nrpr11_1", "nrpr11_2");

    if (nr1.match(numbers) && nr2.match(numbers) && nr3.match(numbers) && found == false){
        var newnr1 = parseFloat (nr1);
        var newnr2 = parseFloat (nr2);
        var newnr3 = parseFloat (nr3);
        

        if ((newnr1 == 0 ) && (newnr2 == 0) && (newnr3 == 0) ){ 
            
                rezInput.value = "Ecuatia este: " + newnr1 + "*X2" + " + " + newnr2 +"*X " + newnr3 + " = 0." + "\n" + "Solutia este: multimea numerelor Reale.";
            } else {
                var delta = newnr2 * newnr2 - 4 * newnr1 * newnr3 ;
                if ( delta < 0) {
                    newnr3 = (newnr3<0 ? "" : "+" ) + newnr3;
                    rezInput.value = "Ecuatia este: " + newnr1 + "*X2" + " + " + newnr2 +"*X " + newnr3 + " = 0." + "\n" + "Solutia este: nu exista solutie in multimea numerelor Reale.";
                } else {
                    var x1 = (- newnr2 + Math.sqrt(delta)) / (2 * newnr1 );
                    var x2 = (- newnr2 - Math.sqrt(delta)) / (2 * newnr1 );
                    var newx1 = Math.round(x1 * 100) / 100;
                    var newx2 = Math.round(x2 * 100) / 100;
                    newnr3 = (newnr3<0 ? "" : "+" ) + newnr3;
                    rezInput.value = "Ecuatia este: " + newnr1 + "*X2" + " + " + newnr2 +"*X " + newnr3 + " = 0." + "\n" + "Solutiile sunt:" + "\n" + "X1 = " + newx1 + "\n" + "X2 = " + newx2;
                }

                
            }
   
       var veziRez=document.getElementById("rezultat");
       veziRez.style.display="block";
    } 
}

function functia12(){
    
    var nr1 = document.getElementById("nrpr12").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d +]+$/;
    var sirul = [];

    if (nr1.match(numbers)){
        for (var i = 1 ; i <= nr1; i++) {
            sirul.push(i);
        }
        rezInput.value = sirul;
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";

    } else {
        alert("Trebuie sa introduci un numar intreg pozitiv!");
        // document.getElementById("nrpr12").value = "";
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    }
}

function functia13(){
    
    var nr1 = document.getElementById("nrpr13").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d +]+$/;
    var sirul = [];

    if (nr1.match(numbers)){
        for (var i = nr1 - 1; i >= 0; i--) {
            sirul.push(i);
        }
        rezInput.value = sirul;
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";

    } else {
        alert("Trebuie sa introduci un numar intreg pozitiv!");
        // document.getElementById("nrpr13").value = "";
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    }
}

function functia14(){
    var nr1 = document.getElementById("nrpr14").value;
    var nr2 = document.getElementById("nrpr14_1").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d +-]+$/;    

    var found = check2Int(nr1, nr2, "nrpr14", "nrpr14_1");

    if (nr1.match(numbers) && nr2.match(numbers) && found == false){
        var newnr1 = parseInt (nr1);
        var newnr2 = parseInt (nr2);

        if (newnr1 >  newnr2 ) {
            alert("Primul numar trebuie sa fie mai mic decat al doilea!");
            // document.getElementById("nrpr14").value = "";
            // document.getElementById("nrpr14_1").value = "";
            var veziRez=document.getElementById("rezultat");
            veziRez.style.display="none";
        }
            
        else{
        var sirul = [];
        for (var i = newnr1 + 1; i < newnr2; i++) {
                sirul.push(i);
        }

        if (sirul.length == 0) {
            rezInput.value = "Pentru intervalul " + "[" + newnr1 + "," + newnr2 + "] nu exista nicio valoare de afisat.";
        } else {
            rezInput.value = "Pentru intervalul " + "[" + newnr1 + "," + newnr2 + "] valorile sunt " + sirul;
            
        }var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
        }
       
    } 
}

function functia15(){
    var nr1 = document.getElementById("nrpr15").value;
    var nr2 = document.getElementById("nrpr15_1").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d +-]+$/;    

    var found = check2Int(nr1, nr2, "nrpr15", "nrpr15_1");

    if (nr1.match(numbers) && nr2.match(numbers) && found == false){
        var newnr1 = parseInt (nr1);
        var newnr2 = parseInt (nr2);

        if (newnr1 >  newnr2 ) {
            alert("Primul numar trebuie sa fie mai mic decat al doilea!");
            // document.getElementById("nrpr15").value = "";
            // document.getElementById("nrpr15_1").value = "";
            var veziRez=document.getElementById("rezultat");
            veziRez.style.display="none";
        }
            
        else{
        var sirul = [];
        for (var i = newnr1 ; i <= newnr2; i++) {
                sirul.push(i);
        }
        rezInput.value = "Pentru intervalul " + "[" + newnr1 + "," + newnr2 + "] valorile sunt " + sirul;
            
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
        }
       
    } 
}


function functia16(){
    var nr1 = document.getElementById("nrpr16").value;
    var nr2 = document.getElementById("nrpr16_1").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d +-]+$/;    

    var found = check2Int(nr1, nr2, "nrpr16", "nrpr16_1");

    if (nr1.match(numbers) && nr2.match(numbers) && found == false){
        var newnr1 = parseInt (nr1);
        var newnr2 = parseInt (nr2);

        if (newnr1 >  newnr2 ) {
            alert("Primul numar trebuie sa fie mai mic decat al doilea!");
            // document.getElementById("nrpr16").value = "";
            // document.getElementById("nrpr16_1").value = "";
            var veziRez=document.getElementById("rezultat");
            veziRez.style.display="none";
        }
            
        else{
        var sirul = [];
        for (var i = newnr1 ; i <= newnr2; i++) {
            if ((i % 2) == 0){ 
                sirul.push(i);}  
        }

        if (sirul.length == 0) {
            rezInput.value = "Pentru intervalul " + "[" + newnr1 + "," + newnr2 + "] nu exista nicio valoare de afisat.";
        } else {
            rezInput.value = "Pentru intervalul " + "[" + newnr1 + "," + newnr2 + "] valorile sunt " + sirul;
        }   
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
        }
       
    } 
}

function functia17(){
    var nr1 = document.getElementById("nrpr17").value;
    var nr2 = document.getElementById("nrpr17_1").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d +-]+$/;    

    var found = check2Int(nr1, nr2, "nrpr17", "nrpr17_1");

    if (nr1.match(numbers) && nr2.match(numbers) && found == false){
        var newnr1 = parseInt (nr1);
        var newnr2 = parseInt (nr2);

        if (newnr1 >  newnr2 ) {
            var a = newnr1;
            newnr1 = newnr2;
            newnr2 = a;
        }
            
        var sirul = [];
        for (var i = newnr1 ; i <= newnr2; i++) {
                sirul.push(i);

        rezInput.value = "Pentru intervalul " + "[" + newnr1 + "," + newnr2 + "] valorile sunt " + sirul;
          
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
        }
       
    } 
}

 function cautaZero() {
     
     var rezInput = document.getElementById("rez");
     var inputEl = document.getElementById("nrpr18");
     var sirul = document.getElementById("nrpr18").value;
     var zeroI = sirul.lastIndexOf("0");
     var bef0 = zeroI - 1;
     var numbers = /^[\d ,+-]+$/;
     var lungSir = sirul.length;

     specialCheck(sirul,inputEl,lungSir);

     if (sirul.match(numbers)) {
        
     var suma = 0;
     var veziRez=document.getElementById("rezultat");
     veziRez.style.display="none";

     if (zeroI == "0") { 
        
        rezInput.value = "Pentru sirul [" + sirul + "] suma numerelor introduse este 0.";
        veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
        document.getElementById("nrpr18").value = "";
        return;
     } else {
        if ((zeroI >= 0) && (sirul.charAt(bef0) == ",") ) {
            elemSir = sirul.split(",");
            // console.log(elemSir);
            var lungEl = elemSir.length;
            elemSir.splice(lungEl,1);
            
            for (var i = 0; i < elemSir.length  ; i++) {
                suma = suma + parseInt(elemSir[i]);
            }
            rezInput.value = "Pentru sirul [" + elemSir + "] suma numerelor introduse este: " + suma + ".";
            veziRez=document.getElementById("rezultat");
            veziRez.style.display="block";
            document.getElementById("nrpr18").value = "";
            
            return;
         }
     } 
     } else { if (lungSir != 0) {
        alert("Doar numere sau virgula!");
        hide();
        sirul = sirul.slice(0,-1);
        inputEl.value = sirul;
     }  
       }

 }

 function functia19(){
    
    var nr1 = document.getElementById("nrpr19").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d +]+$/;
    var sirul = "";
    var a = parseInt(0);
    var b = parseInt(1);

    if (nr1.match(numbers) && (nr1 != 0)){
        
        if (nr1 < 3) {
            for (var i=0; i < nr1; i++) {
                sirul = sirul + i + ", ";
            }
            sirul = sirul.slice(0,-2);
        } else { 
            sirul = a + ", " + b;
            for (i = 3; i <= nr1; i++){
                var c = a + b;
                a = b;
                b = c;
                sirul =  sirul + ", " + c;
            }
        }
        rezInput.value = sirul;
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";

    } else {
        alert("Trebuie sa introduci un numar intreg pozitiv nenul!");
        // document.getElementById("nrpr19").value = "";
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    }
}

function functia20(){
    
    var nr1 = document.getElementById("nrpr20").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d +]+$/;
    var sirul = "0";
    var a = parseInt(0);
    var b = parseInt(1);
    var c = a + b;

    if (nr1.match(numbers) && (nr1 != 0)){
            for (i = 0; i <= nr1; ){
                sirul =  sirul + ", " + c;
                c = a + b;
                a = b;
                b = c;
                
                i = c;
            }
        
        rezInput.value = sirul;
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";

    } else {
        alert("Trebuie sa introduci un numar intreg pozitiv nenul!");
        // document.getElementById("nrpr19").value = "";
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    }
}

function functia21(){
    
    var nr1 = document.getElementById("nrpr21").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d +]+$/;
    var sirul = "";
    

    if (nr1.match(numbers) && (nr1 != 0)){
        if (nr1 != 1){
            for (i = 1; i <= (nr1 / 2); i++){
                if (nr1 % i == 0) {
                    sirul = sirul + i + ", ";
                }
            }
            sirul = sirul + nr1;
        } else {
            sirul = "1";
        }
        
        rezInput.value = "Divizorii numarului " + nr1 + " sunt: " + sirul;
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";

    } else {
        alert("Trebuie sa introduci un numar intreg pozitiv nenul!");
        // document.getElementById("nrpr19").value = "";
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    }
}


function functia22(){
    
    var nr1 = document.getElementById("nrpr22").value;
    var rezInput = document.getElementById("rez");
    
    var numbers = /^[\d +-]+$/;
    var absnr1 = Math.abs(nr1);
    
    if ( (nr1.match(numbers)) && (nr1 != 0)){
        
        if (functiePrim(absnr1) ) {
            rezInput.value = "Numarul " + nr1 + " este prim.";
        } else {
            rezInput.value = "Numarul " + nr1 + " nu este prim.";
        }
        
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";

    } else {
        alert("Trebuie sa introduci un numar intreg nenul!");
        // document.getElementById("nrpr19").value = "";
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    }
}

var commI1 ;
var commI2 ;

function estePrim() {
     
    var rezInput = document.getElementById("rez");
    var inputEl = document.getElementById("nrpr23");
    var sirul = document.getElementById("nrpr23").value;
    var zeroI = sirul.lastIndexOf("0");
    var bef0 = zeroI - 1;
    var numbers = /^[\d ,+-]+$/;
    var lungSir = sirul.length;
    var countComma = (sirul.match(/,/g) || []).length;
    var lastChar = sirul.charAt(lungSir-1);


    specialCheck(sirul,inputEl,lungSir);
    if (lungSir == 1) {
        rezInput.value = "";
        veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";

    }


    if (sirul.match(numbers)) {
       
    

    if (zeroI == "0") { 
       alert("Daca incepi cu 0, nu se va intampla nimic :)!");
       hide();
       document.getElementById("nrpr23").value = "";
    //    return;
    } else {
        if ((zeroI >= 0) && (sirul.charAt(bef0) == ",") ) {
            document.getElementById("nrpr23").value = "";
            // return;
        } else {
       
       if ((lastChar == ",")) {
           if (countComma == 1) {
               commI1 = sirul.indexOf(",");
               commI2 = sirul.indexOf(",");
               var verifNr = parseInt(sirul.slice(0,commI1));
                var absverifNr = Math.abs(verifNr);
                if (functiePrim(absverifNr)) {
                    rezInput.value = "Numarul " + verifNr + " este prim." + "\n";
                } else {
                    rezInput.value = "Numarul " + verifNr + " nu este prim." + "\n";
                }

           } else {
               commI1 = commI2;
               commI2 = sirul.indexOf(",",commI1 + 1);
               verifNr = parseInt(sirul.slice(commI1+1,commI2));
               absverifNr = Math.abs(verifNr);
                if (functiePrim(absverifNr)) {
                    rezInput.value = rezInput.value + "Numarul " + verifNr + " este prim." + "\n";
                } else {
                    rezInput.value = rezInput.value + "Numarul " + verifNr + " nu este prim." + "\n";
                }
           }
           var veziRez=document.getElementById("rezultat");
           veziRez.style.display="block";
       }
   
    } }         
    } 
    else { if (lungSir != 0) {
       alert("Doar numere sau virgula!");
       hide();
       sirul = sirul.slice(0,-1);
       inputEl.value = sirul;
    }  
    }
   

}

function functia24(){
    
    var sirul = document.getElementById("nrpr24").value;
    var rezInput = document.getElementById("rez");
    sirul = sirul.replace(/ /g,"");
    var elemSir = sirul.split(",");
    var lungSir = elemSir.length;
    var min = parseInt(elemSir[0]);
    var sirOk = true;

    for (var i = 0; i < lungSir; i++){
        if (checkNr(elemSir[i])) {
            sirOk = false;
            break;
        } else { 
            var elemI = parseInt(elemSir[i]);
            if (elemI < min) {
            min = elemI;
        }
        }      
    }

    if (sirOk) {
        rezInput.value = "Valoarea minima din sirul [" + elemSir + "] este: " + min;
        veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
    }
}

function functia25(){
    
    var sirul = document.getElementById("nrpr25").value;
    var rezInput = document.getElementById("rez");
    sirul = sirul.replace(/ /g,"");
    var elemSir = sirul.split(",");
    var lungSir = elemSir.length;
    var max = parseInt(elemSir[0]);
    var sirOk = true;

    for (var i = 0; i < lungSir; i++){
        if (checkNr(elemSir[i])) {
            sirOk = false;
            break;
        } else { 
            var elemI = parseInt(elemSir[i]);
            if (elemI > max) {
            max = elemI;
        }
        }      
    }

    if (sirOk) {
        rezInput.value = "Valoarea maxima din sirul [" + elemSir + "] este: " + max;
        veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
    }
}

function functia26(){
    
    var sirul = document.getElementById("nrpr26").value;
    var rezInput = document.getElementById("rez");
    sirul = sirul.replace(/ /g,"");
    var elemSir = sirul.split(",");
    var lungSir = elemSir.length;

    var countMinLoc = 0;
    var minimele = [];
    var sirOk = true;

    for (var i = 0; i < lungSir; i++){
        if (checkNr(elemSir[i])) {
            sirOk = false;
            break;
        } else { 
            if (lungSir == 1){
            rezInput.value = "Sirul [" + elemSir + "] are doar o valoare.";
            } else {
                if (i == 0)  {
                    var elemI = parseInt(elemSir[i]);
                    var elemIn = parseInt(elemSir[i+1]);
                    if (elemI != elemIn) {
                        if (elemI < elemIn) {
                            minimele.push(elemI) ;
                            countMinLoc = countMinLoc + 1;
                        } else {
                            minimele.push(elemIn);
                            countMinLoc = countMinLoc + 1;
                        }
                    }
                    if (lungSir == 2) {i = 2}
                } else { if (i != lungSir-1) {
                    elemI = parseInt(elemSir[i]);
                    elemIn = parseInt(elemSir[i+1]);
                    var elemIb = parseInt(elemSir[i-1]);
                    if ((elemI < elemIn) && (elemI < elemIb)) {
                        minimele.push(elemI);
                        countMinLoc = countMinLoc + 1;
                    }
                } else {
                    elemI = parseInt(elemSir[i]);
                    elemIb = parseInt(elemSir[i-1]);
                    if (elemI < elemIb) {
                        minimele.push(elemI);
                        countMinLoc = countMinLoc + 1;
                    }
                }
                }

            if (countMinLoc == 0) {
                rezInput.value = "Sirul [" + elemSir + "] nu are minime locale."; 
            } else {
                rezInput.value = "Minimele locale pentru sirul [" + elemSir + "] sunt: " + minimele;
            }
            }

        }
        }      

    if (sirOk) {
        veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
    }
}

function functia27(){
    
    var nr1 = document.getElementById("nrpr27").value;
    var rezInput = document.getElementById("rez");
    var numbers = /^[\d +]+$/;
    var sirul = [];
    

    if (nr1.match(numbers) && (nr1 != 0)){
        
        if (nr1 < 3) {
            for (var i=0; i < nr1; i++) {
                sirul.push(i);
            }      
        } else { 
            sirul.push(0);
            sirul.push(1);
            for (i = 2; i < nr1; i++){
                var a = sirul[i-2];
                var b = sirul[i-1];
                sirul.push(a + b);
            }
        }
        rezInput.value = sirul;
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";

    } else {
        alert("Trebuie sa introduci un numar intreg pozitiv nenul!");
        // document.getElementById("nrpr19").value = "";
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    }
}


function functia28(){
    
    var sirul = document.getElementById("nrpr28").value;
    var rezInput = document.getElementById("rez");
    sirul = sirul.replace(/ /g,"");
    var elemSir = sirul.split(",");
    var lungSir = elemSir.length;
    var suma = 0;
  
    var sirOk = true;

    for (var i = 0; i < lungSir; i++){
        if (checkNrReal(elemSir[i])) {
            sirOk = false;
            break;
        } else { 
            var elemI = parseFloat(elemSir[i]);
            suma = suma + elemI;
        }
    }      
    

    if (sirOk) {
        rezInput.value = "Suma elementelor sirului [" + elemSir + "] este:" + suma.toFixed(2);
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
    }
}

function functia29(){
    
    var sirul = document.getElementById("nrpr29").value;
    var rezInput = document.getElementById("rez");
    sirul = sirul.replace(/ /g,"");
    var elemSir = sirul.split(",");
    var lungSir = elemSir.length;
    var suma = 0;
    var valMici = [];
  
    var sirOk = true;

    for (var i = 0; i < lungSir; i++){
        if (checkNrReal(elemSir[i])) {
            sirOk = false;
            break;
        } else { 
            var elemI = parseFloat(elemSir[i]);
            suma = suma + elemI;
        }
    } 
    
    var ma = suma / lungSir;
    for (var i =0; i< lungSir; i++) {
        elemI = parseFloat(elemSir[i]);

        if (elemI < ma) {
            valMici.push(elemI);
        }
    }

    if (sirOk) {
        if (valMici.length == 0) {
            rezInput.value = "Valorile din sirul [" + elemSir + "] sunt egale.";
        }else {
            rezInput.value = "Valorile mai mici decat media aritmetica " + ma.toFixed(2)+" a valorilor din sirul [" + elemSir + "] sunt: [" + valMici + "]";
        }
        
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
    }
}

function functia30(){
    var nr1 = document.getElementById("nrpr30").value;
    var nr2 = document.getElementById("nrpr30_1").value;
    var rezInput = document.getElementById("rez");
    

    if (nr2.length > 1) {
        alert("Scrie doar 1 caracter!");
        veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    } else {

        if  ((nr1.match(new RegExp(nr2, "g") || [])) == null) {
            rezInput.value = "In sirul '" + nr1 + "', caracterul '" + nr2 + "' nu apare niciodata.";

        } else {
        var countChar = (nr1.match(new RegExp(nr2, "g") || [])).length;
        rezInput.value = "In sirul '" + nr1 + "', caracterul '" + nr2 + "' apare de " + countChar + " ori";
    }
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";

       
        
        
    }
   
}

function functia31(){
    var sirul = document.getElementById("nrpr31").value;
    var char = document.getElementById("nrpr31_1").value;
    var rezInput = document.getElementById("rez");
    var pozChar = [];

    if (char.length > 1) {
        alert("Scrie doar 1 caracter!");
        veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    } else {
         
        for (var i = 0; i < sirul.length;){

            var firstI = sirul.indexOf(char,i);

            if (firstI < 0 ) {
                i = sirul.length;
            } else { 
                
                i = firstI + 1;
                pozChar.push(i);
            }

        }

        if (pozChar == "") {
            rezInput.value = "In sirul '" + sirul + "', nu apare caracterul '" + char + "' .";

        } else {
            rezInput.value = "In sirul '" + sirul + "', caracterul '" + char + "' apare pe pozitiile [" + pozChar + "]";
        }
        
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";
    }
   
}

function functia32(){
    var sirul = document.getElementById("nrpr32").value; 
    var rezInput = document.getElementById("rez");
    var nrCuv = 0; 
    var elemSir = sirul.split(" ");
    var lungSir = elemSir.length;
    // var numbers = /[A-Za-z0-9]*/; 

    console.log(elemSir);

    if (lungSir == 1) {
        rezInput.value = "";
        veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";
    }

    for (var i = 0; i < lungSir; i ++) {
        var valoare = elemSir[i];
        if ((elemSir[i].length != 0) && ( (/[0-9]/.test(valoare)) || (/[A-Z]/.test(valoare)) || (/[a-z]/.test(valoare)) )){
            nrCuv ++;
        }
    }

   
    if (nrCuv == 0) {
            rezInput.value = "In sirul '" + sirul + "' nu este niciun cuvant.";

        } else {
            rezInput.value = "In sirul '" + sirul + "' sunt " + nrCuv + " cuvinte";
        }
        
    var veziRez=document.getElementById("rezultat");
    veziRez.style.display="block";
   
}

function functia33(){
    var sirul = document.getElementById("nrpr33").value; 
    const sirulNemod = sirul;
    var rezInput = document.getElementById("rez");
    var nrVocale = 0; 
    var nrChar = 0;
    sirul = sirul.replace(/ /g,"");
    sirul = sirul.toLowerCase();

    var letters = /^[a-z]+$/g;

     if (sirul.match(letters)){

        if ( sirul.match(/[aeiou]/g) == null) {
        rezInput.value = "In sirul '" + sirulNemod + "' sunt doar consoane.";

        }else {
        nrVocale = sirul.match(/[aeiou]/g).length;
        nrChar = sirul.match(/[a-z]/g).length;
        var procent = nrVocale / nrChar * 100;
        rezInput.value = "Pentru sirul '" + sirulNemod + "' procentul de vocale este: " + parseFloat(procent).toFixed(2) + "%.";
        

        }
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="block";


     } else { 
     alert("Trebuie sa introduci doar litere sau spatiu!");
     veziRez=document.getElementById("rezultat");
     veziRez.style.display="none";

     }  
}