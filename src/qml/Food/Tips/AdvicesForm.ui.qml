import QtQuick 2.4
import "../.."

SwipePage {
    id: sweepTipsPage
    title: qsTrId("food-tips")
    property alias itemsContainer: itemsContainer

    SwipeItems{
           id: itemsContainer
    }
}