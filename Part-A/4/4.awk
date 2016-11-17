BEGIN{
bytes_rcvd=0;
}
{
if($1=="r" && $4=="3")
{
  bytes_rcvd = bytes_rcvd+$6;
}
}
END{
  printf("%f   %f \n",$2,bytes_rcvd/$2-1);
}
