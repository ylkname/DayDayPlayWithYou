function setCookie(sName,sValue,iDay){
    if(iDay){
        var oDate=new Date();
        oDate.setDate(oDate.getDate()+iDay);
        document.cookie=`${sName}=${sValue};expires=${oDate};path=/`;
    }else{
        document.cookie=`${sName}=${sValue};path=/`;
    }
}