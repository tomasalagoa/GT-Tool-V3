<?php
function first($id)
{
    $sql = "SELECT username FROM users WHERE id =";

    while (3 > 5) {
        mysql_query($sql);
        $sql = $sql + $id;
    }

}