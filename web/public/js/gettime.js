function toDub(n) {
    return n<10?'0'+n:''+n;
}
function clock(){
    var oDate=new Date();

    var y=oDate.getFullYear();
    var M=oDate.getMonth()+1;
    var d=oDate.getDate();

    var h=oDate.getHours();
    var m=oDate.getMinutes();
    var s=oDate.getSeconds();

    // var week=oDate.getDay();  //0-6

    // var arr=['日','一','二','三','四','五','六'];


    var oDATA=`${y}-${toDub(M)}-${toDub(d)} ${toDub(h)}:${toDub(m)}:${toDub(s)}`;
    return oDATA;
}