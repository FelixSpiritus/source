// Выпадающее меню
$("[data-trigger='dropdown']").on("mouseenter", function () {
  var submenu = $(this).parent().find(".submenu");
  //submenu.addClass("active");
  submenu.fadeIn(300);

  $(".profile-menu").on("mouseleave", function () {
    //submenu.removeClass("active");
    submenu.fadeOut(300);
  })
});

// Кастомное контекстное меню
$(document).on("contextmenu", function () {
  return false;
})

$(document).on("mousedown", function (event) {
  //event.preventDefault();
  //console.log(event.which);

  if (event.which == 3) {
    $(".hidden").removeClass("shown");

    if ($(event.target).is("img")) {
      $(".hidden").addClass("shown");
    }

    
    $("#context").css({
      top: event.pageY,
      left: event.pageX
    })
    $("#context").fadeIn();
    return false;
  }
  $("#context").fadeOut();
})


// //  Переопределние стандартного поведения
// $("[href='http://www.google.ru']").on("click", function (event) {
//   console.log("Переходите на Google?");
//   //event.preventDefault();
//   return false;
// });

// // Множественный доступ к элементам
// $("#prepand, #append, #replace").on("click", function (e) {
//   var el = $(e.currentTarget);
//   var action = el.attr("id");

//   var content = $(".text").val();

//   if (action == "prepand") {
//     console.log("Prep");
//     $("#main").prepend("<a href='#'>" + content + "</a>");
//   } else if (action == "append") {
//     console.log("App");
//     $("#main").append(content);
//   } else if (action == "replace") {
//     console.log("Repl");
//     $("#main").html(content);
//   }
//   $(".text").val("");
// });