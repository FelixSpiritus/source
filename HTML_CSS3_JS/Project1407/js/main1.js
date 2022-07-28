

var btn = document.getElementById("change");


function buttonClicked(){
    console.log("Кнопка была нажата");
    btn.removeEventListener("click",buttonClicked);
    console.log(document.getElementById("text").innerHTML);
    document.getElementById("text").innerHTML="<a href='#'>Контакты. Номер телефона и почтовый адрес.</a>";
    console.log(document.getElementById("text"));
    console.log(document.getElementById("text").innerHTML);
  }
  btn.addEventListener("click",buttonClicked);

//   var string1="string1";
//   var string2="string2";
//   var pi=3.14;
//   var ff;

// alert(string1+string2);
// alert(pi*ff);
  
// var hobbies = ["чтение","рисование","программирование","компьютерные игры"];
// console.log("Список моих хобби:",hobbies);
// console.log("Меня больше не интересует:",hobbies.pop());
// hobbies.push("фильмы");
// console.log(hobbies.shift());
// hobbies.unshift("фитнес");

var films = ["[Хищник","Терминатор","Чужой","Список Шиндлера","Аватар"];
console.log(films);
films.pop();
console.log(films);
films.push("Терминал");
console.log(films);
films.shift();
console.log(films);
films.unshift("Изгой");
console.log(films);

