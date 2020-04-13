<?php 

require_once 'connect.php';

if ( isset($_GET['key']) ){
    $key = $_GET['key'];
    $query = "SELECT * FROM hitung WHERE kategori LIKE '%$key%'";
    $result = mysqli_query($conn, $query);
        $response = array();
        while( $row = mysqli_fetch_assoc($result) ){
            array_push($response, 
            array( 
                'kategori'=>$row['kategori'],
                'jumlah'=>$row['jumlah']) 
            );
        }
        echo json_encode($response);   
    
} else {
    $query = "SELECT * FROM hitung";
    	$result = mysqli_query($conn, $query);
	    $response = array();
	    while( $row = mysqli_fetch_assoc($result) ){
	        array_push($response, 
            array(
                'kategori'=>$row['kategori'],
                'jumlah'=>$row['jumlah']) 
            );
        }
        echo json_encode($response);   
    }


mysqli_close($conn);

?>