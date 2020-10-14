var totaltime = 60, tout;
var timer = function (totaltime)
{
    var reg = /^\d$/;
    var h = Math.floor (totaltime / 60 / 60);
    h = reg.test (h) ? "0" + h : h;
    var m = Math.floor (totaltime / 60 % 60);
    m = reg.test (m) ? "0" + m : m;
    var s = Math.floor (totaltime % 60);
    s = reg.test (s) ? "0" + s : s;
    var str = h + ":" + m + ":" + s;
    $ (".odjs").text (str);
    if (str == "00:00:00")
    {
        clearTimeout (tout);
        return;
    }
    tout = setTimeout (function ()
    {
        timer (--totaltime);
    }, 1000);
};

jQuery (function ($)
{
    timer (totaltime);
});