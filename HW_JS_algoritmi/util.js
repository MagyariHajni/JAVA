var prevID = "pr1";
var txtSelected = "";
var functia = "";


function getText(slction){
    var button=document.getElementById("calculate");
    button.style.display="none";

        var veziRez = document.getElementById("rezultat");
        veziRez.style.display = "none";

        var prevEl = document.getElementById(prevID);
        prevEl.style.display = "none";
       
        
        
        txtSelected = slction.selectedIndex;
        
        var theID="pr"+ txtSelected;
        var theVisible=document.getElementById(theID);
        theVisible.style.display="inline";
        prevID = theID;

        // if ((theID != "pr18") && (theID != "pr23") && (theID != "pr34")){button=document.getElementById("calculate");
        // button.style.display="inline";

        // }

          
        if ((parseInt(txtSelected) == 0) || (theID == "pr18") || (theID == "pr23") || (theID == "pr34")) {
            button.style.display="none";
        } else {
            var theID="pr"+ txtSelected;
            var theVisible=document.getElementById(theID);
            theVisible.style.display="inline";
            prevID = theID; 
            button.style.display="block";
        }
      

}
      

function functiile(){
            functia= "functia" + txtSelected;
            var func = new Function(functia + "()")();
            
}


function hide() {
    
        var veziRez=document.getElementById("rezultat");
        veziRez.style.display="none";

}

function functiePrim (nr) {
        var estePr = true;
        var count = 0;
        if (nr != 1){
            for (i = 1; i <= (nr / 2); i++){
                if (nr % i == 0) {
                    count = count + 1;
                }
            }
            count = count + 1;
        } else {
            count = 2;
        }  
        if (count != 2 ) {
            estePr = false;
        }
        return estePr;
}

function check2(a, b, nrpr, nrpr_1) {
    var found = false;
    var numbers = /^[\d .,+-]+$/;
    
    var sirul1 = document.getElementById(nrpr).value;
    var sirul2 = document.getElementById(nrpr_1).value;
    var lungSir1 = sirul1.length;
    var lungSir2 = sirul2.length;

    var pozSp1 = sirul1.lastIndexOf(" ");
    var pozSp2 = sirul2.lastIndexOf(" ");

    var pozPl1 = sirul1.lastIndexOf("+");
    var pozPl2 = sirul2.lastIndexOf("+");
    var pozMi1 = sirul1.lastIndexOf("-");
    var pozMi2 = sirul2.lastIndexOf("-");

    if ((sirul1.charAt(pozPl1-1) != NaN) && (pozPl1 > 0) ){
        alert("Inainte de + nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }

    if ((sirul2.charAt(pozPl2-1) != NaN) && (pozPl2 > 0) ){
        alert("Inainte de + nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }
    
    if ((sirul1.charAt(pozMi1-1) != NaN) && (pozMi1 > 0) ){
        alert("Inainte de - nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }

    if ((sirul2.charAt(pozMi2-1) != NaN) && (pozMi2 > 0) ){
        alert("Inainte de - nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }
   

    if ((sirul1.charAt(pozSp1) == " ") && (lungSir1 != 0)) {
        alert("Fara spatii!");
        hide();
        found= true;
        return found;
     }

     if ((sirul2.charAt(pozSp2) == " ") && (lungSir2 != 0)) {
        alert("Fara spatii!");
        hide();
        found= true;
        return found;
     }

     if (sirul1.charAt(0) == " ")  {
        alert("Nu poate incepe cu spatiu!");
        hide();
        found= true;
        return found;
     }

     if (sirul2.charAt(0) == " ")  {
        alert("Nu poate incepe cu spatiu!");
        hide();
        found= true;
        return found;
     }

    if (a.match(numbers) && b.match(numbers)){
        // found=false;
    } else if ((a == "") || (b == "")) {
        alert("Nu ai introdus toate valorile!");
        hide();
        found= true;
        return found;
    } else { 
    alert("Ambele valori trebuie sa fie numerice!");
        hide();
        found= true;
        return found;
    }

    if (a.includes(".")) {
        dotCount1= a.match((/\./g)|| []).length;
    } else {
        dotCount1 = 0;
    }

    if (a.includes(",")) {
        var commaCount1= a.match((/\,/g)|| []).length;
    } else {
        commaCount1 = 0;
    }

    if (b.includes(".")) {
        dotCount2= b.match((/\./g)|| []).length;
    } else {
        dotCount2 = 0;
    }

    if (b.includes(",")) {
        var commaCount2= b.match((/\,/g)|| []).length;
    } else {
        commaCount2 = 0;
    }

    if ((commaCount1 >=1) || (commaCount2 >=1)) {
        alert("Foloseste . in loc de , !");
        hide();
        found= true;
        return found;
    }

    if ( (dotCount1 > 1) || (dotCount2 > 1)) {
        alert("Ambele valori trebuie sa fie numerice!");
        hide();
        found= true;
        return found;
    }

    return found;
}

function check2Int(a, b, nrpr, nrpr_1) {
    var found = false;
    var numbers = /^[\d +-]+$/;

    var sirul1 = document.getElementById(nrpr).value;
    var sirul2 = document.getElementById(nrpr_1).value;
    var lungSir1 = sirul1.length;
    var lungSir2 = sirul2.length;

    var pozSp1 = sirul1.lastIndexOf(" ");
    var pozSp2 = sirul2.lastIndexOf(" ");

    var pozPl1 = sirul1.lastIndexOf("+");
    var pozPl2 = sirul2.lastIndexOf("+");
    var pozMi1 = sirul1.lastIndexOf("-");
    var pozMi2 = sirul2.lastIndexOf("-");

    if ((sirul1.charAt(pozPl1-1) != NaN) && (pozPl1 > 0) ){
        alert("Inainte de + nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }

    if ((sirul2.charAt(pozPl2-1) != NaN) && (pozPl2 > 0) ){
        alert("Inainte de + nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }
    
    if ((sirul1.charAt(pozMi1-1) != NaN) && (pozMi1 > 0) ){
        alert("Inainte de - nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }

    if ((sirul2.charAt(pozMi2-1) != NaN) && (pozMi2 > 0) ){
        alert("Inainte de - nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }
   

    if ((sirul1.charAt(pozSp1) == " ") && (lungSir1 != 0)) {
        alert("Fara spatii!");
        hide();
        found= true;
        return found;
     }

     if ((sirul2.charAt(pozSp2) == " ") && (lungSir2 != 0)) {
        alert("Fara spatii!");
        hide();
        found= true;
        return found;
     }

     if (sirul1.charAt(0) == " ")  {
        alert("Nu poate incepe cu spatiu!");
        hide();
        found= true;
        return found;
     }

     if (sirul2.charAt(0) == " ")  {
        alert("Nu poate incepe cu spatiu!");
        hide();
        found= true;
        return found;
     }


    if (a.match(numbers) && b.match(numbers)){
        // found=false;
    } else if ((a == "") || (b == "")) {
        alert("Nu ai introdus toate valorile!");
        hide();
        found= true;
        return found;
    } 

    if (a.includes(".")) {
        dotCount1= a.match((/\./g)|| []).length;
    } else {
        dotCount1 = 0;
    }

    if (a.includes(",")) {
        var commaCount1= a.match((/\,/g)|| []).length;
    } else {
        commaCount1 = 0;
    }

    if (b.includes(".")) {
        dotCount2= b.match((/\./g)|| []).length;
    } else {
        dotCount2 = 0;
    }

    if (b.includes(",")) {
        var commaCount2= b.match((/\,/g)|| []).length;
    } else {
        commaCount2 = 0;
    }

    if ((commaCount1 >=1) || (commaCount2 >=1) || (dotCount1 >= 1) || (dotCount2 >= 1)) {
        alert("Trebuie introduse numere intregi!");
        hide();
        found= true;
        return found;
    }
    return found;
}

function check3(a, b, c, nrpr, nrpr_1, nrpr_2) {
    var found = false;
    var numbers = /^[\d .,+-]+$/;

    var sirul1 = document.getElementById(nrpr).value;
    var sirul2 = document.getElementById(nrpr_1).value;
    var sirul3 = document.getElementById(nrpr_2).value;
    var lungSir1 = sirul1.length;
    var lungSir2 = sirul2.length;
    var lungSir3 = sirul3.length;


    var pozSp1 = sirul1.lastIndexOf(" ");
    var pozSp2 = sirul2.lastIndexOf(" ");
    var pozSp3 = sirul3.lastIndexOf(" ");


    var pozPl1 = sirul1.lastIndexOf("+");
    var pozPl2 = sirul2.lastIndexOf("+");
    var pozPl3 = sirul3.lastIndexOf("+");


    var pozMi1 = sirul1.lastIndexOf("-");
    var pozMi2 = sirul2.lastIndexOf("-");
    var pozMi3 = sirul3.lastIndexOf("-");


    if ((sirul1.charAt(pozPl1-1) != NaN) && (pozPl1 > 0) ){
        alert("Inainte de + nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }

    if ((sirul2.charAt(pozPl2-1) != NaN) && (pozPl2 > 0) ){
        alert("Inainte de + nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }

    if ((sirul3.charAt(pozPl3-1) != NaN) && (pozPl3 > 0) ){
        alert("Inainte de + nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }

    
    if ((sirul1.charAt(pozMi1-1) != NaN) && (pozMi1 > 0) ){
        alert("Inainte de - nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }

    if ((sirul2.charAt(pozMi2-1) != NaN) && (pozMi2 > 0) ){
        alert("Inainte de - nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }

    if ((sirul3.charAt(pozMi3-1) != NaN) && (pozMi3 > 0) ){
        alert("Inainte de - nu poate fi numar sau spatiu!");
        hide();
        found= true;
        return found;
    }
   

    if ((sirul1.charAt(pozSp1) == " ") && (lungSir1 != 0)) {
        alert("Fara spatii!");
        hide();
        found= true;
        return found;
     }

     if ((sirul2.charAt(pozSp2) == " ") && (lungSir2 != 0)) {
        alert("Fara spatii!");
        hide();
        found= true;
        return found;
     }

     if ((sirul3.charAt(pozSp3) == " ") && (lungSir3 != 0)) {
        alert("Fara spatii!");
        hide();
        found= true;
        return found;
     }

     if (sirul1.charAt(0) == " ")  {
        alert("Nu poate incepe cu spatiu!");
        hide();
        found= true;
        return found;
     }

     if (sirul2.charAt(0) == " ")  {
        alert("Nu poate incepe cu spatiu!");
        hide();
        found= true;
        return found;
     }

     if (sirul3.charAt(0) == " ")  {
        alert("Nu poate incepe cu spatiu!");
        hide();
        found= true;
        return found;
     }



    if (a.match(numbers) && b.match(numbers) && c.match(numbers) ){
        found=false;
    } else if ((a == "") || (b == "") || (c == "")) {
        alert("Nu ai introdus toate valorile!");
        hide();
        found= true;
        return found;
    } else { 
    alert("Toate valorile trebuie sa fie numerice!");
        hide();
        found= true;
        return found;
    }

    if (a.includes(".")) {
        dotCount1= a.match((/\./g)|| []).length;
    } else {
        dotCount1 = 0;
    }

    if (a.includes(",")) {
        var commaCount1= a.match((/\,/g)|| []).length;
    } else {
        commaCount1 = 0;
    }

    if (b.includes(".")) {
        dotCount2= b.match((/\./g)|| []).length;
    } else {
        dotCount2 = 0;
    }

    if (b.includes(",")) {
        var commaCount2= b.match((/\,/g)|| []).length;
    } else {
        commaCount2 = 0;
    }
     
    if (c.includes(".")) {
        dotCount3= c.match((/\./g)|| []).length;
    } else {
        dotCount3 = 0;
    }

    if (c.includes(",")) {
        var commaCount3= c.match((/\,/g)|| []).length;
    } else {
        commaCount3 = 0;
    }



    if ((commaCount1 >=1) || (commaCount2 >=1) || (commaCount3 >=1) ) {
        alert("Foloseste . in loc de , !");
        hide();
        found= true;
        return found;
    }

    if ( (dotCount1 > 1) || (dotCount2 > 1) || (dotCount3 > 1)) {
        alert("Toate valorile trebuie sa fie numerice!");
        hide();
        found= true;
        return found;
    }

    return found;
}

function specialCheck(sirul,inputEl,lungSir){
    if ((sirul.charAt(0) == ",") || (sirul.charAt(0) == " ")) {
        alert("Nu poate incepe cu spatiu sau virgula!");
        hide();
        sirul = sirul.slice(0,-1);
        inputEl.value = sirul;
     }

     if ((sirul.charAt(lungSir-1) == ",") && (sirul.charAt(lungSir-2) == ",")) {
        alert("Nu poti avea 2 virgule una langa alta!");
        hide();
        sirul = sirul.slice(0,-1);
        inputEl.value = sirul;
     }

     if ((sirul.charAt(lungSir-1) == ",") && ((sirul.charAt(lungSir-2) == "+") || (sirul.charAt(lungSir-2) == "-"))) {
        alert("Dupa + sau - trebuie sa urmeze un numar!");
        hide();
        sirul = sirul.slice(0,-1);
        inputEl.value = sirul;
     }
     

     if (lungSir > 1) {
     if ((sirul.charAt(lungSir-2) != ",") && ((sirul.charAt(lungSir-1) == "+") || (sirul.charAt(lungSir-1) == "-")) ) {
        alert("Inainte de + sau - trebuie sa fie virgula!");
        hide();
        sirul = sirul.slice(0,-1);
        inputEl.value = sirul;
     }}



     if ((sirul.charAt(lungSir-1) == " ") && (lungSir != 0)) {
        alert("Fara spatii, sirul se desparte cu virgula!");
        hide();
        sirul = sirul.slice(0,-1);
        inputEl.value = sirul;
     }
  
}

function checkNr(nr){
    
    var countComma = (nr.match(/\./g) || []).length;
    
    var indexPl = nr.lastIndexOf("+");
    var indexMi = nr.lastIndexOf("-");
    var numbers = /^[\d .+-]+$/;
    var countSg = indexPl + indexMi;


    var found = false;

    if ((countComma > 0)){
        alert("Toate numerele trebuie sa fie intregi, fara . , separate prin , !")
        found = true;
        hide();
        return found;

    }

    if ( (countSg >1)){
        alert("Verifica semnele +-, numerele trebuie sa fie intregi, separate prin , !")
        found = true;
        hide();
        return found;
    }

    if  (indexPl > 0 ) {
        alert("Verifica pozitia semnului +, numerele trebuie sa fie intregi, separate prin , !")
        found = true;
        hide();
        return found;
    }

    if (indexMi > 0 ) {
        alert("Verifica pozitia semnului -, numerele trebuie sa fie intregi, separate prin , !")
        found = true;
        hide();
        return found;
    }

    if (!nr.match(numbers)) {
        alert("Toate valorile trebuie sa fie numere intregi, separate prin , !")
        found = true;
        hide();
        return found;
    }

return found;
}

function checkNrReal(nr){
    
    var countComma = (nr.match(/\./g) || []).length;
    
    var indexPl = nr.lastIndexOf("+");
    var indexMi = nr.lastIndexOf("-");
    var numbers = /^[\d .+-]+$/;
    var countSg = indexPl + indexMi;


    var found = false;

    if ((countComma > 1)){
        alert("Toate valorile trebuie sa fie numerice, separate prin , !")
        found = true;
        hide();
        return found;
    }

    if ( (countSg >1)){
        alert("Verifica semnele +-, valorile trebuie sa fie numerice, separate prin , !")
        found = true;
        hide();
        return found;
    }

    if  (indexPl > 0 ) {
        alert("Verifica pozitia semnului +, valorile trebuie sa fie numerice, separate prin , !")
        found = true;
        hide();
        return found;
    }

    if (indexMi > 0 ) {
        alert("Verifica pozitia semnului -, valorile trebuie sa fie numerice, separate prin , !")
        found = true;
        hide();
        return found;
    }

    if (!nr.match(numbers)) {
        alert("Toate valorile trebuie sa fie numerice, separate prin , !")
        found = true;
        hide();
        return found;
    }

return found;
}