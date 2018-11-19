
(deftemplate sensor
   (slot name)
   (slot value)
   (slot type)
)

(deftemplate Action
       (slot command)  
)
(deftemplate roomstate
       (slot state)  
)

(defrule d_status-1
    (sensor (name ?x) (value ?y) (type ?z))
    (sensor {value < 10})
    => (assert (roomstate (state dark)))
 )

(defrule d_action-1
    (roomstate (state dark))
    => (assert (Action (command turn-up-light)))  
)    

(run)
