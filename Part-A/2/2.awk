//use awk -f 2.awk 2.tr

BEGIN{
	stcp=0;
	rtcp=0;
	sudp=0;
	rtcp=0;
}
{
	if($1=="+" && $3=="0")
		stcp++;
	if($1=="+" && $3=="1")
		sudp++;
	if($1=="r" && $4=="3")
		rtcp++;

}
END{
	print "TCP ";
	print stcp;
	print "\nUDP :"
	print sudp;
	print "\n";
	print rtcp;
}
