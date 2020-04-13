<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {

    $name = $_POST['name'];
    $password = $_POST['password'];

    require_once 'connect.php';

    $sql = "SELECT * FROM users WHERE name='$name' ";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['login'] = array();
    
    if ( mysqli_num_rows($response) === 1 ) {
        
        $row = mysqli_fetch_assoc($response);

        if ( password_verify($password, $row['password']) ) {
            
            $index['name'] = $row['name'];
            $index['email'] = $row['email'];
            $index['id'] = $row['id'];
            array_push($result['login'], $index);
            $result['success'] = "1";
        } else {
   $result['success'] = "0";
  }
    }
   echo json_encode($result);
            mysqli_close($conn);
}

?>