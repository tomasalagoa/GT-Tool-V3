<?php

include "example2.php";

//$tainted_id = "taintedId";
//
//class foo
//{
//
//    var $attribute1 = "my value";
//    var $price;
//
//    function __construct($priceArg)
//    {
//        $this->price = $priceArg;
//    }
//
//    function do_foo($query)
//    {
//        return mysql_query($query);
//    }
//
//    function method($query)
//    {
//        return mysql_query($query);
//    }
//}


function first($id)
{

//
//    $bar = new foo(1231);
//
//    $my_price = $bar -> $price;
//
//
//
//    $sql = "SELECT * from users WHERE user.name= " . $id;
//
//    $bar->do_foo($sql);
//
    $baz = new foo("asda");

    $baz->do_foo("Select * from users")->do_another()->price;

//
//    $non_tainted = ("asasdas" + 1222) + "asdasd";
//
//    if ($sql == "asdasd") {
//        $sql = $id;
//
//        if ($sql == $id) {
//            $new_sql = mysql_query($sql);
//
//            if (3 > 5) {
//                $abc = "query";
//            } else {
//                return $new_sql;
//            }
//
//        } else {
//            return mysql_query("Outra query");
//        }
//
//    } elseif ($id < 3) {
//        $sql = $id;
//    } else {
//        $sql = "null" + $id;
//    }
//    $sql = $id;
//    $taint = another_function($sql, "asdas");
//    $abc = "asda";
//    $result = mysql_query($sql);
//
//    $new_result = mysql_query($result);
//
//    return $result;
}


//function another_function($input, $expr)
//{
//    return $input;
//}


