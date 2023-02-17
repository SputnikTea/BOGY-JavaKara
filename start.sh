#!/bin/bash
# Bash Menu Script Example

PS3='Please enter your choice: '
options=("JavaKara" "Kara" "MultiKara" "Quit")
select opt in "${options[@]}"
do
    case $opt in
        "JavaKara")
            echo "Starting JavaKara"
            java -jar ./karas/javakara.jar
            ;;
        "Kara")
            echo "Starting Kara"
            java -jar ./karas/kara.jar
            ;;
        "MultiKara")
            echo "Starting MultiKara"
            java -jar ./karas/multikara.jar
            ;;
        "Quit")
            break
            ;;
        *) echo "invalid option $REPLY";;
    esac
done

