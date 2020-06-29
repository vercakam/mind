#ifndef IOSNATIVE_H
#define IOSNATIVE_H
#include <QString>


class IosNative
{
public:
    static void updateNotifications(std::string title, std::string message);
    static void cancelNotifications();
private:
     static const QString identifier;
};
#endif // IOSNATIVE_H
