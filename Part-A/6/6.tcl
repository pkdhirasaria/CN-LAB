# This script is created by NSG2 beta1
# <http://wushoupong.googlepages.com/nsg>

#===================================
#     Simulation parameters setup
#===================================
set val(stop)   10.0                         ;# time of simulation end

#===================================
#        Initialization        
#===================================
#Create a ns simulator
set ns [new Simulator]

#Open the NS trace file
set tracefile [open six.tr w]
$ns trace-all $tracefile

#Open the NAM trace file
set namfile [open six.nam w]
$ns namtrace-all $namfile

#===================================
#        Nodes Definition        
#===================================
#Create 3 nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

#===================================
#        Links Definition        
#===================================
#Createlinks between nodes
$ns duplex-link $n0 $n1 1.0Mb 10ms DropTail
$ns queue-limit $n0 $n1 5
$ns duplex-link $n2 $n1 1.0Mb 10ms DropTail
$ns queue-limit $n2 $n1 5

#Give node position (for NAM)
$ns duplex-link-op $n0 $n1 orient right-down
$ns duplex-link-op $n2 $n1 orient right-up

#===================================
#        Agents Definition        
#===================================
set ping0 [new Agent/Ping]
$ns attach-agent $n0 $ping0
set ping1 [new Agent/Ping]
$ns attach-agent $n1 $ping1
$ns connect $ping0 $ping1

#===================================
#        Applications Definition        
#===================================


Agent/Ping instproc recv {from rtt} {
  $self instvar node_
  puts "The node [$node_ id] received a reply from $ from with round trip time of $rtt"
}


$ns rtmodel-at 0.9 down $n0 $n1
$ns rtmodel-at 1.5 up $n0 $n1
$ns at 0.1 "$ping0 send"
#===================================
#        Termination        
#===================================
#Define a 'finish' procedure
proc finish {} {
    global ns tracefile namfile
    $ns flush-trace
    close $tracefile
    close $namfile
    exec nam six.nam &
    exit 0
}
$ns at $val(stop) "$ns nam-end-wireless $val(stop)"
$ns at $val(stop) "finish"
$ns at $val(stop) "puts \"done\" ; $ns halt"
$ns run
