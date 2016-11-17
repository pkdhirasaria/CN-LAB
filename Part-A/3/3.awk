BEGIN{
	b_recevd=0;
}

{
	if($1=="r" && $4=="4")
	{
		b_recevd=b_recevd+$6;
		printf("%f %f\n",$2,b_recevd/$2-1);
	}
}

END{
}
